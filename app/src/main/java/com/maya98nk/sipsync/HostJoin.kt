package com.maya98nk.sipsync


import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class HostJoin : AppCompatActivity() {
    lateinit var codeEdt: EditText
    lateinit var createCodeBtn: Button
    lateinit var joinCodeBtn: Button
    lateinit var loadingPB: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host_join)
        joinCodeBtn = findViewById<Button>(R.id.button2)
        createCodeBtn = findViewById<Button>(R.id.button1)
        loadingPB = findViewById<ProgressBar>(R.id.idPBloading)
        codeEdt = findViewById(R.id.idet)


        // Inside the onCreate method of your activity
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // For Android 11 and above
            window.insetsController?.hide(WindowInsets.Type.statusBars())
            window.insetsController?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        } else {
            // For versions below Android 11
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    )
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        // Check if the user has joined a room before
        if (hasJoinedRoom()) {
            // User has joined a room before, navigate to the third page
            navigateToSyncedTracker()
        } else {
            // User hasn't joined a room before, continue with the normal flow
            setupJoinButton()
        }



        joinCodeBtn.setOnClickListener {
            val enteredCode = codeEdt.text.toString().trim()

            if (enteredCode.isNotEmpty()) {
                createCodeBtn.visibility = View.GONE
                joinCodeBtn.visibility = View.GONE
                codeEdt.visibility = View.GONE
                loadingPB.visibility = View.VISIBLE

                val gamesRef = FirebaseDatabase.getInstance().reference.child("room").child("room1") // Change to "room"
                gamesRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var codeFound = false
                        for (gameSnapshot in snapshot.children) {
                            val code = gameSnapshot.getValue(String::class.java)
                            if (code.equals(enteredCode, ignoreCase = true)) {
                                codeFound = true
                                setJoinedRoomFlag()
                                navigateToSyncedTracker()
                                break
                            }
                        }

                        if (!codeFound) {
                            createCodeBtn.visibility = View.VISIBLE
                            joinCodeBtn.visibility = View.VISIBLE
                            codeEdt.visibility = View.VISIBLE
                            loadingPB.visibility = View.GONE
                            Toast.makeText(this@HostJoin, "Invalid Code", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        createCodeBtn.visibility = View.VISIBLE
                        joinCodeBtn.visibility = View.VISIBLE
                        codeEdt.visibility = View.VISIBLE
                        loadingPB.visibility = View.GONE
                        Toast.makeText(this@HostJoin, "Database Error", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(this@HostJoin, "Enter a code", Toast.LENGTH_SHORT).show()
            }
        }




        createCodeBtn.setOnClickListener {
            val code = codeEdt.text.toString().trim()



            if (code != null) {
                setIsHost(true)


                createGame(code)
                setJoinedRoomFlag()
            } else {
                Toast.makeText(this@HostJoin, "Failed to generate code.", Toast.LENGTH_SHORT).show()
            }
        }
    }



    private fun createGame(code: String) {
        loadingPB.visibility = View.VISIBLE
        FirebaseDatabase.getInstance().reference.child("room").child("room1").push().setValue(code)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {


                    // Do not set the flag here; it should be set when the user successfully joins a room
                    startActivity(Intent(this@HostJoin, syncedTracker::class.java))
                    // Set isHost to true when the host button is clicked
                    setIsHost(true)

                    setJoinedRoomFlag()
                    finish()
                } else {
                    Toast.makeText(this@HostJoin, "Failed to create the game.", Toast.LENGTH_SHORT).show()
                }
                loadingPB.visibility = View.GONE
            }
    }
    private fun setIsHost(isHost: Boolean) {



        // Use SharedPreferences to store isHost value
        val sharedPreferences11 = getSharedPreferences("myPreferences", MODE_PRIVATE)
        sharedPreferences11.edit().putBoolean("myPreferences", isHost).apply()
        Log.d("SharedPreferences11", "isHost set to: $isHost")







    }

    private fun hasJoinedRoom(): Boolean {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("HAS_JOINED_ROOM", false)
    }

    private fun setJoinedRoomFlag() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean("HAS_JOINED_ROOM", true).apply()
    }

    private fun navigateToSyncedTracker() {
        val intent = Intent(this, syncedTracker::class.java)
        startActivity(intent)
        finish()
    }

    private fun setupJoinButton() {
        joinCodeBtn.setOnClickListener {
            setIsHost(false)
            val enteredCode = codeEdt.text.toString().trim()

            if (enteredCode.isNotEmpty()) {
                createCodeBtn.visibility = View.GONE
                joinCodeBtn.visibility = View.GONE
                codeEdt.visibility = View.GONE
                loadingPB.visibility = View.VISIBLE

                val gamesRef = FirebaseDatabase.getInstance().reference.child("games")
                gamesRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var codeFound = false
                        for (gameSnapshot in snapshot.children) {
                            val code = gameSnapshot.getValue(String::class.java)
                            if (code.equals(enteredCode, ignoreCase = true)) {
                                codeFound = true
                                setJoinedRoomFlag() // Set the flag when the user joins a room
                                setIsHost(false)
                                navigateToSyncedTracker() // Navigate to the third page
                                break
                            }
                        }

                        if (!codeFound) {
                            createCodeBtn.visibility = View.VISIBLE
                            joinCodeBtn.visibility = View.VISIBLE
                            codeEdt.visibility = View.VISIBLE
                            loadingPB.visibility = View.GONE
                            Toast.makeText(this@HostJoin, "Invalid Code", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        createCodeBtn.visibility = View.VISIBLE
                        joinCodeBtn.visibility = View.VISIBLE
                        codeEdt.visibility = View.VISIBLE
                        loadingPB.visibility = View.GONE
                        Toast.makeText(this@HostJoin, "Database Error", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(this@HostJoin, "Enter a code", Toast.LENGTH_SHORT).show()
            }

        }


    }


}
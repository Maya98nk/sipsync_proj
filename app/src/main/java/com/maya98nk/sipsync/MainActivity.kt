package com.maya98nk.sipsync

import com.google.firebase.database.DatabaseError
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.content.Intent
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import android.app.Application
import android.util.Log
import androidx.activity.viewModels
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver


class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}
class CounterViewModel : ViewModel() {
    var counter: Int = 0
}



class MainActivity : AppCompatActivity() {

    private lateinit var lottieAnimationView: LottieAnimationView
    private lateinit var lottieAnimationView2: LottieAnimationView
    private lateinit var lottieAnimationView3: LottieAnimationView
    private lateinit var lottieAnimationView4: LottieAnimationView
    private lateinit var lottieAnimationView5: LottieAnimationView
    private lateinit var lottieAnimationView6: LottieAnimationView
    private lateinit var lottieAnimationView7: LottieAnimationView
    private lateinit var lottieAnimationView8: LottieAnimationView





    private var counter = 0
    private lateinit var glassCounter: TextView

    private lateinit var counterViewModel: CounterViewModel

    


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)










        
        // Get the current date
        val currentDate = Date()
        // Format the date to display the day
        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        val formattedDay = dayFormat.format(currentDate)
        // Assuming you have a TextView in your layout with the ID 'textViewDay'
        val textViewDay: TextView = findViewById(R.id.textView)
        textViewDay.text = formattedDay








        // Initialize the glassCounter TextView with the counter value
        glassCounter = findViewById(R.id.glassCount)
        glassCounter.text = counter.toString()


        // Initialize the ViewModel
        counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        // Retrieve the counter value from the ViewModel
        counter = counterViewModel.counter


        // Initialize SharedPreferences
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        // Retrieve the counter value from SharedPreferences
        counter = sharedPreferences.getInt("counter", 0)


        // Inside the onCreate method of your activity
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // For Android 11 and above
            window.insetsController?.hide(WindowInsets.Type.statusBars())
            window.insetsController?.systemBarsBehavior =
                WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        } else {
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


        val pairPg: ImageButton = findViewById(R.id.pairPg)

        pairPg.setOnClickListener {
            // Create an Intent to open SecondActivity
            val intent = Intent(this, HostJoin::class.java)
            startActivity(intent)
        }
        val pastAc: ImageButton = findViewById(R.id.imageButton2)

        pastAc.setOnClickListener {
            // Create an Intent to open SecondActivity
            val intent = Intent(this, pastActivity::class.java)
            startActivity(intent)
        }

        lottieAnimationView = findViewById(R.id.lottie1)
        lottieAnimationView2 = findViewById(R.id.lottie2)
        lottieAnimationView3 = findViewById(R.id.lottie3)
        lottieAnimationView4 = findViewById(R.id.lottie4)
        lottieAnimationView5 = findViewById(R.id.lottie5)
        lottieAnimationView6 = findViewById(R.id.lottie6)
        lottieAnimationView7 = findViewById(R.id.lottie7)
        lottieAnimationView8 = findViewById(R.id.lottie8)


        //
        lottieAnimationView.visibility = View.VISIBLE
        lottieAnimationView2.visibility = View.INVISIBLE
        lottieAnimationView3.visibility = View.INVISIBLE
        lottieAnimationView4.visibility = View.INVISIBLE
        lottieAnimationView5.visibility = View.INVISIBLE
        lottieAnimationView6.visibility = View.INVISIBLE
        lottieAnimationView7.visibility = View.INVISIBLE
        lottieAnimationView8.visibility = View.INVISIBLE


        // Initialize the glassCounter TextView with the counter value
        glassCounter.text = counter.toString()

        if (counter == 1) {
            lottieAnimationView.visibility = View.VISIBLE
            lottieAnimationView2.visibility = View.INVISIBLE

            lottieAnimationView.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView.visibility = View.INVISIBLE
                    lottieAnimationView2.visibility = View.VISIBLE
                }
            })
        }


        if (counter == 2) {
            lottieAnimationView.visibility = View.INVISIBLE
            lottieAnimationView2.visibility = View.VISIBLE

            lottieAnimationView2.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView2.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView.visibility = View.INVISIBLE
                    lottieAnimationView2.visibility = View.INVISIBLE
                    lottieAnimationView3.visibility = View.VISIBLE

                }
            })
        }

        if (counter == 3) {
            lottieAnimationView.visibility = View.INVISIBLE
            lottieAnimationView2.visibility = View.INVISIBLE
            lottieAnimationView3.visibility = View.VISIBLE

            lottieAnimationView3.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView3.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView.visibility = View.INVISIBLE
                    lottieAnimationView2.visibility = View.INVISIBLE
                    lottieAnimationView3.visibility = View.INVISIBLE
                    lottieAnimationView4.visibility = View.VISIBLE

                }
            })
        }



        if (counter == 4) {
            lottieAnimationView.visibility = View.INVISIBLE
            lottieAnimationView2.visibility = View.INVISIBLE
            lottieAnimationView3.visibility = View.INVISIBLE
            lottieAnimationView4.visibility = View.VISIBLE

            lottieAnimationView4.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView4.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView.visibility = View.INVISIBLE
                    lottieAnimationView2.visibility = View.INVISIBLE
                    lottieAnimationView3.visibility = View.INVISIBLE
                    lottieAnimationView4.visibility = View.INVISIBLE
                    lottieAnimationView5.visibility = View.VISIBLE

                }
            })
        }
        if (counter == 5) {
            lottieAnimationView.visibility = View.INVISIBLE
            lottieAnimationView2.visibility = View.INVISIBLE
            lottieAnimationView3.visibility = View.INVISIBLE
            lottieAnimationView4.visibility = View.INVISIBLE
            lottieAnimationView5.visibility = View.VISIBLE

            lottieAnimationView5.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView5.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView.visibility = View.INVISIBLE
                    lottieAnimationView2.visibility = View.INVISIBLE
                    lottieAnimationView3.visibility = View.INVISIBLE
                    lottieAnimationView4.visibility = View.INVISIBLE
                    lottieAnimationView5.visibility = View.INVISIBLE
                    lottieAnimationView6.visibility = View.VISIBLE

                }
            })
        }
        if (counter == 6) {
            lottieAnimationView.visibility = View.INVISIBLE
            lottieAnimationView2.visibility = View.INVISIBLE
            lottieAnimationView3.visibility = View.INVISIBLE
            lottieAnimationView4.visibility = View.INVISIBLE
            lottieAnimationView5.visibility = View.INVISIBLE
            lottieAnimationView6.visibility = View.VISIBLE

            lottieAnimationView6.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView6.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView.visibility = View.INVISIBLE
                    lottieAnimationView2.visibility = View.INVISIBLE
                    lottieAnimationView3.visibility = View.INVISIBLE
                    lottieAnimationView4.visibility = View.INVISIBLE
                    lottieAnimationView5.visibility = View.INVISIBLE
                    lottieAnimationView6.visibility = View.INVISIBLE
                    lottieAnimationView7.visibility = View.VISIBLE

                }
            })
        }
        if (counter == 7) {
            lottieAnimationView.visibility = View.INVISIBLE
            lottieAnimationView2.visibility = View.INVISIBLE
            lottieAnimationView3.visibility = View.INVISIBLE
            lottieAnimationView4.visibility = View.INVISIBLE
            lottieAnimationView5.visibility = View.INVISIBLE
            lottieAnimationView6.visibility = View.INVISIBLE
            lottieAnimationView7.visibility = View.VISIBLE
            lottieAnimationView7.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView4.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView.visibility = View.INVISIBLE
                    lottieAnimationView2.visibility = View.INVISIBLE
                    lottieAnimationView3.visibility = View.INVISIBLE
                    lottieAnimationView4.visibility = View.INVISIBLE
                    lottieAnimationView5.visibility = View.INVISIBLE
                    lottieAnimationView6.visibility = View.INVISIBLE
                    lottieAnimationView7.visibility = View.INVISIBLE
                    lottieAnimationView8.visibility = View.VISIBLE
                }
            })
        }
        if (counter == 8) {
            lottieAnimationView.visibility = View.INVISIBLE
            lottieAnimationView2.visibility = View.INVISIBLE
            lottieAnimationView3.visibility = View.INVISIBLE
            lottieAnimationView4.visibility = View.INVISIBLE
            lottieAnimationView5.visibility = View.INVISIBLE
            lottieAnimationView6.visibility = View.INVISIBLE
            lottieAnimationView7.visibility = View.INVISIBLE
            lottieAnimationView8.visibility = View.VISIBLE
            lottieAnimationView8.playAnimation()
        }


        // Set an onClickListener to the LottieAnimationView
        lottieAnimationView.setOnClickListener {
            // Save the counter value to SharedPreferences

            counter++
            glassCounter.text = counter.toString()
            counterViewModel.counter = counter
            getIsHost()

            updateCounterInFirebase(counter, getIsHost())

            // Play the first animation
            lottieAnimationView.playAnimation()


            // Set a listener to hide the first animation when it completes
            lottieAnimationView.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    // Hide the first animation after it completes
                    lottieAnimationView.visibility = View.INVISIBLE
                    lottieAnimationView2.visibility = View.VISIBLE
                    // Save the counter value to SharedPreferences
                    with(sharedPreferences.edit()) {
                        putInt("counter", counter)
                        apply()
                    }
                }
            })
        }




        lottieAnimationView2.setOnClickListener {
            counter++
            glassCounter.text = counter.toString()
            getIsHost()
            updateCounterInFirebase(counter, getIsHost())

            // Play the first animation
            lottieAnimationView2.playAnimation()


            // Set a listener to hide the first animation when it completes
            lottieAnimationView2.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    // Hide the first animation after it completes

                    lottieAnimationView.visibility = View.INVISIBLE
                    lottieAnimationView2.visibility = View.INVISIBLE
                    lottieAnimationView3.visibility = View.VISIBLE
                    // Save the counter value to SharedPreferences
                    with(sharedPreferences.edit()) {
                        putInt("counter", counter)
                        apply()
                    }


                }
            })
        }


        lottieAnimationView3.setOnClickListener {
            counter++
            glassCounter.text = counter.toString()
            getIsHost()
            updateCounterInFirebase(counter, getIsHost())
            // Play the first animation
            lottieAnimationView3.playAnimation()

            // Set a listener to hide the first animation when it completes
            lottieAnimationView3.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    // Hide the first animation after it completes
                    lottieAnimationView3.visibility = View.INVISIBLE
                    lottieAnimationView4.visibility = View.VISIBLE
                    // Save the counter value to SharedPreferences
                    with(sharedPreferences.edit()) {
                        putInt("counter", counter)
                        apply()
                    }

                }
            })
        }



        lottieAnimationView4.setOnClickListener {
            counter++
            glassCounter.text = counter.toString()
            getIsHost()

            updateCounterInFirebase(counter, getIsHost())
            // Play the first animation
            lottieAnimationView4.playAnimation()

            // Set a listener to hide the first animation when it completes
            lottieAnimationView4.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    // Hide the first animation after it completes
                    lottieAnimationView4.visibility = View.INVISIBLE
                    lottieAnimationView5.visibility = View.VISIBLE
                    // Save the counter value to SharedPreferences
                    with(sharedPreferences.edit()) {
                        putInt("counter", counter)
                        apply()
                    }

                }
            })
        }



        lottieAnimationView5.setOnClickListener {
            counter++
            glassCounter.text = counter.toString()
            getIsHost()
            updateCounterInFirebase(counter, getIsHost())
            // Play the first animation
            lottieAnimationView5.playAnimation()

            // Set a listener to hide the first animation when it completes
            lottieAnimationView5.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    // Hide the first animation after it completes
                    lottieAnimationView5.visibility = View.INVISIBLE
                    lottieAnimationView6.visibility = View.VISIBLE
                    // Save the counter value to SharedPreferences
                    with(sharedPreferences.edit()) {
                        putInt("counter", counter)
                        apply()
                    }

                }
            })
        }


        lottieAnimationView6.setOnClickListener {
            counter++
            glassCounter.text = counter.toString()
            getIsHost()
            updateCounterInFirebase(counter, getIsHost())
            // Play the first animation
            lottieAnimationView6.playAnimation()

            // Set a listener to hide the first animation when it completes
            lottieAnimationView6.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    // Hide the first animation after it completes
                    lottieAnimationView6.visibility = View.INVISIBLE
                    lottieAnimationView7.visibility = View.VISIBLE
                    // Save the counter value to SharedPreferences
                    with(sharedPreferences.edit()) {
                        putInt("counter", counter)
                        apply()
                    }

                }
            })
        }



        lottieAnimationView7.setOnClickListener {
            counter++
            glassCounter.text = counter.toString()
            getIsHost()
            updateCounterInFirebase(counter, getIsHost())
            // Play the first animation
            lottieAnimationView7.playAnimation()

            // Set a listener to hide the first animation when it completes
            lottieAnimationView7.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    // Hide the first animation after it completes
                    lottieAnimationView7.visibility = View.INVISIBLE
                    lottieAnimationView8.visibility = View.VISIBLE
                    // Save the counter value to SharedPreferences
                    with(sharedPreferences.edit()) {
                        putInt("counter", counter)
                        apply()
                    }

                }
            })
        }


        lottieAnimationView8.setOnClickListener {
            counter++
            glassCounter.text = counter.toString()
            getIsHost()
            updateCounterInFirebase(counter, getIsHost())

            // Play the first animation
            lottieAnimationView8.playAnimation()
            // Save the counter value to SharedPreferences
            with(sharedPreferences.edit()) {
                putInt("counter", counter)
                apply()
            }
            if (counter == 8) {
                lottieAnimationView8.isClickable = false
            }

        }







    }
    private fun getIsHost(): Boolean {
        // Retrieve isHost value from SharedPreferences
        val sharedPreferences11 = getSharedPreferences("myPreferences", MODE_PRIVATE)
        val isHost = sharedPreferences11.getBoolean("myPreferences", false)





        Log.d("SharedPreferences11", "isHost retrieved as: $isHost")

        return isHost


    }



    private fun updateCounterInFirebase(counter: Int, isHost: Boolean) {
        // Get a reference to the database
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        Log.d("SharedPreferences", "isHost set to: $isHost")

        // Choose the appropriate path based on whether the user is the host
        val counterPath = if (isHost) "room/room1/host/counter" else "room/room1/join/counter"

        val counterRef: DatabaseReference = database.getReference(counterPath)

        // Update the counter value in the database
        counterRef.setValue(counter)
    }



}


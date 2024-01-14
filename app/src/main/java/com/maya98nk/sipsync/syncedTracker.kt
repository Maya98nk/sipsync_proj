package com.maya98nk.sipsync

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
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale




class MyApp1 : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}
class CounterViewModel1 : ViewModel() {
    var counter: Int = 0
}

class CounterViewModel11 : ViewModel() {
    var counter1: Int = 0
}


class syncedTracker : AppCompatActivity() {
    private lateinit var lottieAnimationView11: LottieAnimationView
    private lateinit var lottieAnimationView12: LottieAnimationView
    private lateinit var lottieAnimationView13: LottieAnimationView
    private lateinit var lottieAnimationView14: LottieAnimationView
    private lateinit var lottieAnimationView15: LottieAnimationView
    private lateinit var lottieAnimationView16: LottieAnimationView
    private lateinit var lottieAnimationView17: LottieAnimationView
    private lateinit var lottieAnimationView18: LottieAnimationView


    private lateinit var lottieAnimationView21: LottieAnimationView
    private lateinit var lottieAnimationView22: LottieAnimationView
    private lateinit var lottieAnimationView23: LottieAnimationView
    private lateinit var lottieAnimationView24: LottieAnimationView
    private lateinit var lottieAnimationView25: LottieAnimationView
    private lateinit var lottieAnimationView26: LottieAnimationView
    private lateinit var lottieAnimationView27: LottieAnimationView
    private lateinit var lottieAnimationView28: LottieAnimationView


    private var counter = 0
    private lateinit var glassCounter1: TextView
    private var counter1 = 0
    private lateinit var glassCounter21: TextView





    private lateinit var counterViewModel: CounterViewModel1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_synced_tracker)


        // Get the current date
        val currentDate = Date()
        // Format the date to display the day
        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        val formattedDay = dayFormat.format(currentDate)
        // Assuming you have a TextView in your layout with the ID 'textViewDay'
        val textViewDay: TextView = findViewById(R.id.textView)
        textViewDay.text = formattedDay










        // Initialize the ViewModel
        counterViewModel = ViewModelProvider(this)[CounterViewModel1::class.java]

        // Retrieve the counter value from the ViewModel
        counter = counterViewModel.counter





        // Initialize the glassCounter TextView with the counter value
        glassCounter1 = findViewById(R.id.glassCount1)
        glassCounter1.text = counter.toString()



        // Initialize the glassCounter TextView with the counter value
        glassCounter21 = findViewById(R.id.glassCount21)
        glassCounter21.text = counter1.toString()








        // Get a reference to the database
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        if(getIsHost()) {
            val counterRef: DatabaseReference = database.getReference("room/room1/host/counter")
            // Add a ValueEventListener to get the counter value from Firebase
            counterRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // Get the counter value from Firebase
                    val firebaseCounter = dataSnapshot.getValue(Long::class.java)

                    // Update the ViewModel's counter
                    counterViewModel.counter = firebaseCounter?.toInt() ?: 0
                    counter = firebaseCounter?.toInt() ?: 0

                    // Update the UI with the new counter value
                    glassCounter1.text = counterViewModel.counter.toString()

                    // Initialize LottieAnimationViews if not done in onCreate
                    lottieAnimationView11 = findViewById(R.id.lottie11)
                    lottieAnimationView12 = findViewById(R.id.lottie12)
                    lottieAnimationView13 = findViewById(R.id.lottie13)
                    lottieAnimationView14 = findViewById(R.id.lottie14)
                    lottieAnimationView15 = findViewById(R.id.lottie15)
                    lottieAnimationView16 = findViewById(R.id.lottie16)
                    lottieAnimationView17 = findViewById(R.id.lottie17)
                    lottieAnimationView18 = findViewById(R.id.lottie18)

                    // Set initial visibility for LottieAnimationViews
                    lottieAnimationView11.visibility = View.VISIBLE
                    lottieAnimationView12.visibility = View.INVISIBLE
                    lottieAnimationView13.visibility = View.INVISIBLE
                    lottieAnimationView14.visibility = View.INVISIBLE
                    lottieAnimationView15.visibility = View.INVISIBLE
                    lottieAnimationView16.visibility = View.INVISIBLE
                    lottieAnimationView17.visibility = View.INVISIBLE
                    lottieAnimationView18.visibility = View.INVISIBLE

                    // Initialize the glassCounter TextView with the counter value
                    glassCounter1 = findViewById(R.id.glassCount1)
                    glassCounter1.text = "0"

                    // Update the glassCounter TextView with the counter value
                    glassCounter1.text = counter.toString()

                    // Move your animation logic here
                    updateAnimations(counter)

                    val counterRef1: DatabaseReference = database.getReference("room/room1/join/counter")
                    // Add a ValueEventListener to get the counter value from Firebase
                    // Add a ValueEventListener to get the counter value from Firebase
                    counterRef1.addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            // Get the counter value from Firebase
                            val firebaseCounter1 = dataSnapshot.getValue(Long::class.java)

                            // Update the ViewModel's counter
                            counterViewModel.counter = firebaseCounter1?.toInt() ?: 0
                            counter1 = firebaseCounter1?.toInt() ?: 0

                            // Update the UI with the new counter value
                            glassCounter21.text = counterViewModel.counter.toString()

                            // Initialize LottieAnimationViews if not done in onCreate
                            lottieAnimationView21 = findViewById(R.id.lottie21)
                            lottieAnimationView22 = findViewById(R.id.lottie22)
                            lottieAnimationView23 = findViewById(R.id.lottie23)
                            lottieAnimationView24 = findViewById(R.id.lottie24)
                            lottieAnimationView25 = findViewById(R.id.lottie25)
                            lottieAnimationView26 = findViewById(R.id.lottie26)
                            lottieAnimationView27 = findViewById(R.id.lottie27)
                            lottieAnimationView28 = findViewById(R.id.lottie28)

                            // Set initial visibility for LottieAnimationViews
                            lottieAnimationView21.visibility = View.VISIBLE
                            lottieAnimationView22.visibility = View.INVISIBLE
                            lottieAnimationView23.visibility = View.INVISIBLE
                            lottieAnimationView24.visibility = View.INVISIBLE
                            lottieAnimationView25.visibility = View.INVISIBLE
                            lottieAnimationView26.visibility = View.INVISIBLE
                            lottieAnimationView27.visibility = View.INVISIBLE
                            lottieAnimationView28.visibility = View.INVISIBLE

                            // Initialize the glassCounter TextView with the counter value
                            glassCounter1 = findViewById(R.id.glassCount1)
                            glassCounter1.text = "0"

                            // Update the glassCounter TextView with the counter value
                            glassCounter1.text = counter.toString()
                            Log.d("value of counter :","$counter1")
                            Log.d("Type of counter1:", "${counter1::class.simpleName}")

                            // Move your animation logic here

                            updateAnimations2(counter1)
                        }


                        override fun onCancelled(error: DatabaseError) {
                            // Handle errors, or leave it empty if you don't want to take any action on cancellation
                        }
                    })
                }


                override fun onCancelled(error: DatabaseError) {
                    // Handle errors, or leave it empty if you don't want to take any action on cancellation
                }
            })


        }


        if(getIsHost() == false) {
            val counterRef: DatabaseReference = database.getReference("room/room1/join/counter")

            counterRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // Get the counter value from Firebase
                    val firebaseCounter = dataSnapshot.getValue(Long::class.java)

                    // Update the ViewModel's counter
                    counterViewModel.counter = firebaseCounter?.toInt() ?: 0
                    counter1 = firebaseCounter?.toInt() ?: 0

                    // Update the UI with the new counter value
                    glassCounter21.text = counterViewModel.counter.toString()
                    Log.d("value of counter1","$counter1")
                    Log.d("value of glasscounter21","$glassCounter21")




                    // Initialize LottieAnimationViews if not done in onCreate
                    lottieAnimationView21 = findViewById(R.id.lottie21)
                    lottieAnimationView22 = findViewById(R.id.lottie22)
                    lottieAnimationView23 = findViewById(R.id.lottie23)
                    lottieAnimationView24 = findViewById(R.id.lottie24)
                    lottieAnimationView25 = findViewById(R.id.lottie25)
                    lottieAnimationView26 = findViewById(R.id.lottie26)
                    lottieAnimationView27 = findViewById(R.id.lottie27)
                    lottieAnimationView28 = findViewById(R.id.lottie28)

                    // Set initial visibility for LottieAnimationViews
                    lottieAnimationView21.visibility = View.VISIBLE
                    lottieAnimationView22.visibility = View.INVISIBLE
                    lottieAnimationView23.visibility = View.INVISIBLE
                    lottieAnimationView24.visibility = View.INVISIBLE
                    lottieAnimationView25.visibility = View.INVISIBLE
                    lottieAnimationView26.visibility = View.INVISIBLE
                    lottieAnimationView27.visibility = View.INVISIBLE
                    lottieAnimationView28.visibility = View.INVISIBLE

                    // Initialize the glassCounter TextView with the counter value
                    glassCounter21 = findViewById(R.id.glassCount21)
                    glassCounter21.text = "0"

                    // Update the glassCounter TextView with the counter value
                    glassCounter21.text = counter1.toString()

                    // Move your animation logic here
                    updateAnimations2(counter1)

                    val counterRef1: DatabaseReference = database.getReference("room/room1/host/counter")

                    // Add a ValueEventListener to get the counter value from Firebase
                    counterRef1.addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            // Get the counter value from Firebase
                            val firebaseCounter1 = dataSnapshot.getValue(Long::class.java)

                            // Update the ViewModel's counter
                            counterViewModel.counter = firebaseCounter1?.toInt() ?: 0
                            counter = firebaseCounter1?.toInt() ?: 0

                            // Update the UI with the new counter value
                            glassCounter1.text = counterViewModel.counter.toString()

                            // Initialize LottieAnimationViews if not done in onCreate
                            lottieAnimationView11 = findViewById(R.id.lottie11)
                            lottieAnimationView12 = findViewById(R.id.lottie12)
                            lottieAnimationView13 = findViewById(R.id.lottie13)
                            lottieAnimationView14 = findViewById(R.id.lottie14)
                            lottieAnimationView15 = findViewById(R.id.lottie15)
                            lottieAnimationView16 = findViewById(R.id.lottie16)
                            lottieAnimationView17 = findViewById(R.id.lottie17)
                            lottieAnimationView18 = findViewById(R.id.lottie18)

                            // Set initial visibility for LottieAnimationViews
                            lottieAnimationView11.visibility = View.VISIBLE
                            lottieAnimationView12.visibility = View.INVISIBLE
                            lottieAnimationView13.visibility = View.INVISIBLE
                            lottieAnimationView14.visibility = View.INVISIBLE
                            lottieAnimationView15.visibility = View.INVISIBLE
                            lottieAnimationView16.visibility = View.INVISIBLE
                            lottieAnimationView17.visibility = View.INVISIBLE
                            lottieAnimationView18.visibility = View.INVISIBLE

                            // Initialize the glassCounter TextView with the counter value
                            glassCounter1 = findViewById(R.id.glassCount1)
                            glassCounter1.text = "0"

                            // Update the glassCounter TextView with the counter value
                            glassCounter1.text = counter.toString()

                            // Move your animation logic here
                            updateAnimations(counter)






                        }


                        override fun onCancelled(error: DatabaseError) {
                            // Handle errors, or leave it empty if you don't want to take any action on cancellation
                        }
                    })

                }


                override fun onCancelled(error: DatabaseError) {
                    // Handle errors, or leave it empty if you don't want to take any action on cancellation
                }
            })

        }


        // Initialize the glassCounter TextView with the counter value
        glassCounter1 = findViewById(R.id.glassCount1)
        glassCounter1.text = counter.toString()


        // Inside the onCreate method of your activity
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // For Android 11 and above
            window.insetsController?.hide(WindowInsets.Type.statusBars())
            window.insetsController?.systemBarsBehavior =
                WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
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

        val Homepg: ImageButton = findViewById(R.id.imageButton)

        Homepg.setOnClickListener {
            // Create an Intent to open SecondActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }














        }

    private fun updateAnimations2(countervalue: Int){
        Log.d("playing animations","$counter1")


        if (countervalue == 1) {
            lottieAnimationView21.visibility = View.VISIBLE
            lottieAnimationView22.visibility = View.INVISIBLE

            lottieAnimationView21.playAnimation()


            // Set a listener to hide the views when the animation completes
            lottieAnimationView21.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView21.visibility = View.INVISIBLE
                    lottieAnimationView22.visibility = View.VISIBLE
                }
            })
        }


        if (countervalue == 2) {
            lottieAnimationView21.visibility = View.INVISIBLE
            lottieAnimationView22.visibility = View.VISIBLE

            lottieAnimationView22.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView22.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView21.visibility = View.INVISIBLE
                    lottieAnimationView22.visibility = View.INVISIBLE
                    lottieAnimationView23.visibility = View.VISIBLE

                }
            })
        }

        if (countervalue == 3) {
            lottieAnimationView21.visibility = View.INVISIBLE
            lottieAnimationView22.visibility = View.INVISIBLE
            lottieAnimationView23.visibility = View.VISIBLE

            lottieAnimationView23.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView23.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView21.visibility = View.INVISIBLE
                    lottieAnimationView22.visibility = View.INVISIBLE
                    lottieAnimationView23.visibility = View.INVISIBLE
                    lottieAnimationView24.visibility = View.VISIBLE

                }
            })
        }



        if (countervalue == 4) {
            lottieAnimationView21.visibility = View.INVISIBLE
            lottieAnimationView22.visibility = View.INVISIBLE
            lottieAnimationView23.visibility = View.INVISIBLE
            lottieAnimationView24.visibility = View.VISIBLE

            lottieAnimationView24.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView24.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView21.visibility = View.INVISIBLE
                    lottieAnimationView22.visibility = View.INVISIBLE
                    lottieAnimationView23.visibility = View.INVISIBLE
                    lottieAnimationView24.visibility = View.INVISIBLE
                    lottieAnimationView25.visibility = View.VISIBLE

                }
            })
        }
        if (countervalue == 5) {
            lottieAnimationView21.visibility = View.INVISIBLE
            lottieAnimationView22.visibility = View.INVISIBLE
            lottieAnimationView23.visibility = View.INVISIBLE
            lottieAnimationView24.visibility = View.INVISIBLE
            lottieAnimationView25.visibility = View.VISIBLE
            lottieAnimationView25.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView25.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView21.visibility = View.INVISIBLE
                    lottieAnimationView22.visibility = View.INVISIBLE
                    lottieAnimationView23.visibility = View.INVISIBLE
                    lottieAnimationView24.visibility = View.INVISIBLE
                    lottieAnimationView25.visibility = View.INVISIBLE
                    lottieAnimationView26.visibility = View.VISIBLE

                }
            })
        }
        if (countervalue == 6) {
            lottieAnimationView21.visibility = View.INVISIBLE
            lottieAnimationView22.visibility = View.INVISIBLE
            lottieAnimationView23.visibility = View.INVISIBLE
            lottieAnimationView24.visibility = View.INVISIBLE
            lottieAnimationView25.visibility = View.INVISIBLE
            lottieAnimationView26.visibility = View.VISIBLE

            lottieAnimationView26.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView26.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView21.visibility = View.INVISIBLE
                    lottieAnimationView22.visibility = View.INVISIBLE
                    lottieAnimationView23.visibility = View.INVISIBLE
                    lottieAnimationView24.visibility = View.INVISIBLE
                    lottieAnimationView25.visibility = View.INVISIBLE
                    lottieAnimationView26.visibility = View.INVISIBLE
                    lottieAnimationView27.visibility = View.VISIBLE
                }
            })
        }
        if (countervalue == 7) {
            lottieAnimationView21.visibility = View.INVISIBLE
            lottieAnimationView22.visibility = View.INVISIBLE
            lottieAnimationView23.visibility = View.INVISIBLE
            lottieAnimationView24.visibility = View.INVISIBLE
            lottieAnimationView25.visibility = View.INVISIBLE
            lottieAnimationView26.visibility = View.INVISIBLE
            lottieAnimationView27.visibility = View.VISIBLE
            lottieAnimationView27.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView27.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView21.visibility = View.INVISIBLE
                    lottieAnimationView22.visibility = View.INVISIBLE
                    lottieAnimationView23.visibility = View.INVISIBLE
                    lottieAnimationView24.visibility = View.INVISIBLE
                    lottieAnimationView25.visibility = View.INVISIBLE
                    lottieAnimationView26.visibility = View.INVISIBLE
                    lottieAnimationView27.visibility = View.INVISIBLE
                    lottieAnimationView28.visibility = View.VISIBLE
                }
            })
        }
        if (countervalue == 8) {
            lottieAnimationView21.visibility = View.INVISIBLE
            lottieAnimationView22.visibility = View.INVISIBLE
            lottieAnimationView23.visibility = View.INVISIBLE
            lottieAnimationView24.visibility = View.INVISIBLE
            lottieAnimationView25.visibility = View.INVISIBLE
            lottieAnimationView26.visibility = View.INVISIBLE
            lottieAnimationView27.visibility = View.INVISIBLE
            lottieAnimationView28.visibility = View.VISIBLE
            lottieAnimationView28.playAnimation()
        }
    }





    private fun updateAnimations(countervalue : Int) {

        if (countervalue == 1) {
            lottieAnimationView11.visibility = View.VISIBLE
            lottieAnimationView12.visibility = View.INVISIBLE

            lottieAnimationView11.playAnimation()


            // Set a listener to hide the views when the animation completes
            lottieAnimationView11.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView11.visibility = View.INVISIBLE
                    lottieAnimationView12.visibility = View.VISIBLE
                }
            })
        }


        if (countervalue == 2) {
            lottieAnimationView11.visibility = View.INVISIBLE
            lottieAnimationView12.visibility = View.VISIBLE

            lottieAnimationView12.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView12.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView11.visibility = View.INVISIBLE
                    lottieAnimationView12.visibility = View.INVISIBLE
                    lottieAnimationView13.visibility = View.VISIBLE

                }
            })
        }

        if (countervalue == 3) {
            lottieAnimationView11.visibility = View.INVISIBLE
            lottieAnimationView12.visibility = View.INVISIBLE
            lottieAnimationView13.visibility = View.VISIBLE

            lottieAnimationView13.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView13.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView11.visibility = View.INVISIBLE
                    lottieAnimationView12.visibility = View.INVISIBLE
                    lottieAnimationView13.visibility = View.INVISIBLE
                    lottieAnimationView14.visibility = View.VISIBLE

                }
            })
        }



        if (countervalue == 4) {
            lottieAnimationView11.visibility = View.INVISIBLE
            lottieAnimationView12.visibility = View.INVISIBLE
            lottieAnimationView13.visibility = View.INVISIBLE
            lottieAnimationView14.visibility = View.VISIBLE

            lottieAnimationView14.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView14.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView11.visibility = View.INVISIBLE
                    lottieAnimationView12.visibility = View.INVISIBLE
                    lottieAnimationView13.visibility = View.INVISIBLE
                    lottieAnimationView14.visibility = View.INVISIBLE
                    lottieAnimationView15.visibility = View.VISIBLE

                }
            })
        }
        if (countervalue == 5) {
            lottieAnimationView11.visibility = View.INVISIBLE
            lottieAnimationView12.visibility = View.INVISIBLE
            lottieAnimationView13.visibility = View.INVISIBLE
            lottieAnimationView14.visibility = View.INVISIBLE
            lottieAnimationView15.visibility = View.VISIBLE

            lottieAnimationView15.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView15.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView11.visibility = View.INVISIBLE
                    lottieAnimationView12.visibility = View.INVISIBLE
                    lottieAnimationView13.visibility = View.INVISIBLE
                    lottieAnimationView14.visibility = View.INVISIBLE
                    lottieAnimationView15.visibility = View.INVISIBLE
                    lottieAnimationView16.visibility = View.VISIBLE

                }
            })
        }
        if (countervalue == 6) {
            lottieAnimationView11.visibility = View.INVISIBLE
            lottieAnimationView12.visibility = View.INVISIBLE
            lottieAnimationView13.visibility = View.INVISIBLE
            lottieAnimationView14.visibility = View.INVISIBLE
            lottieAnimationView15.visibility = View.INVISIBLE
            lottieAnimationView16.visibility = View.VISIBLE

            lottieAnimationView16.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView16.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView11.visibility = View.INVISIBLE
                    lottieAnimationView12.visibility = View.INVISIBLE
                    lottieAnimationView13.visibility = View.INVISIBLE
                    lottieAnimationView14.visibility = View.INVISIBLE
                    lottieAnimationView15.visibility = View.INVISIBLE
                    lottieAnimationView16.visibility = View.INVISIBLE
                    lottieAnimationView17.visibility = View.VISIBLE
                }
            })
        }
        if (countervalue == 7) {
            lottieAnimationView11.visibility = View.INVISIBLE
            lottieAnimationView12.visibility = View.INVISIBLE
            lottieAnimationView13.visibility = View.INVISIBLE
            lottieAnimationView14.visibility = View.INVISIBLE
            lottieAnimationView15.visibility = View.INVISIBLE
            lottieAnimationView16.visibility = View.INVISIBLE
            lottieAnimationView17.visibility = View.VISIBLE
            lottieAnimationView17.playAnimation()

            // Set a listener to hide the views when the animation completes
            lottieAnimationView17.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView11.visibility = View.INVISIBLE
                    lottieAnimationView12.visibility = View.INVISIBLE
                    lottieAnimationView13.visibility = View.INVISIBLE
                    lottieAnimationView14.visibility = View.INVISIBLE
                    lottieAnimationView15.visibility = View.INVISIBLE
                    lottieAnimationView16.visibility = View.INVISIBLE
                    lottieAnimationView17.visibility = View.INVISIBLE
                    lottieAnimationView18.visibility = View.VISIBLE
                }
            })
        }
        if (countervalue == 8) {
            lottieAnimationView11.visibility = View.INVISIBLE
            lottieAnimationView12.visibility = View.INVISIBLE
            lottieAnimationView13.visibility = View.INVISIBLE
            lottieAnimationView14.visibility = View.INVISIBLE
            lottieAnimationView15.visibility = View.INVISIBLE
            lottieAnimationView16.visibility = View.INVISIBLE
            lottieAnimationView17.visibility = View.INVISIBLE
            lottieAnimationView18.visibility = View.VISIBLE
            lottieAnimationView18.playAnimation()
        }
    }
    private fun getIsHost(): Boolean {
        // Retrieve isHost value from SharedPreferences
        val sharedPreferences11 = getSharedPreferences("myPreferences", MODE_PRIVATE)
        val isHost = sharedPreferences11.getBoolean("myPreferences", false)

        Log.d("SharedPreferences11 synced trakcer ", "isHost retrieved as: $isHost")

        return isHost


    }

}




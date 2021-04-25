package com.example.navigation

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val CHANNEL_ID="channel_id_01"
    private  val notificationId=101

    lateinit var navControler: NavController


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createNotificationChannel1()

        binding.notiButton.setOnClickListener {
            sendNotification()
        }

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragment)
        if (navHostFragment != null) {
            navControler=navHostFragment.findNavController()
        }

        binding.bottomNav.setupWithNavController(navControler)


        setupActionBarWithNavController(navControler)
    }

    private fun createNotificationChannel1() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val name="Notification Tittle"
            val description=" Notification Description"
            val importance:Int=NotificationManager.IMPORTANCE_DEFAULT

            val channel1: NotificationChannel=NotificationChannel(CHANNEL_ID,name,importance).apply {
               // description=descriptionText
            }
            val notificationManager:NotificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel1)

        }
    }

    private fun  sendNotification(){

        val intent:Intent=Intent(this,MainActivity::class.java).apply {
            flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent:PendingIntent= PendingIntent.getActivities(this,0, arrayOf(intent),0)

        val builder:NotificationCompat.Builder=NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Example")
            .setContentText("First notification description")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(this)){
            notify(notificationId,builder.build())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navControler) || super.onOptionsItemSelected(item)
    }
    override fun onSupportNavigateUp(): Boolean {

        //val navController= findNavController(R.id.fragment)
        return navControler.navigateUp() || super.onSupportNavigateUp()
    }
}
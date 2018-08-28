package rharj.com.bottomnavigationsample.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import rharj.com.bottomnavigationsample.R
import rharj.com.bottomnavigationsample.fragment.DashboardFragment
import rharj.com.bottomnavigationsample.fragment.HomeFragment
import rharj.com.bottomnavigationsample.fragment.NotificationFragment

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                //message.setText(R.string.title_home)
                val homFrag = HomeFragment()
                loadFragment(homFrag)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
               // message.setText(R.string.title_dashboard)
                val dashFrag = DashboardFragment()
                loadFragment(dashFrag)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
               // message.setText(R.string.title_notifications)
                val notificationFrag = NotificationFragment()
                loadFragment(notificationFrag)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        //loads the first fragment on launch
        val homFragment = HomeFragment()
        loadFragment(homFragment)
    }


     fun loadFragment(fragment: Fragment) {
         // load fragment
         val frgamentTransaction : FragmentTransaction  = getSupportFragmentManager().beginTransaction()
         frgamentTransaction.replace(R.id.fragment_container, fragment)
         frgamentTransaction.addToBackStack(null)
         frgamentTransaction.commit()
     }
}

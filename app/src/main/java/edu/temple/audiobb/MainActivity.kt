package edu.temple.audiobb

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import edu.temple.audiobb.BookDetailsFragment
import edu.temple.audiobb.BookListFragment


class MainActivity : AppCompatActivity() {
    var count=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_container,
                BookListFragment()
            )
            .commit()
    }
    fun setData(name:String?, name1:String?, name2: String?){
        count=2;
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                BookDetailsFragment(name,name1,name2)
            )
            .commit()
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode==KeyEvent.KEYCODE_BACK&&count==2){
            count=1
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    BookListFragment()
                )
                .commit()
            return true
        }

        return super.onKeyDown(keyCode, event)

    }
}
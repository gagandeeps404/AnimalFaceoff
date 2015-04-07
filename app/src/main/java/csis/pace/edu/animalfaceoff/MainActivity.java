package csis.pace.edu.animalfaceoff;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBtnClicked(View v){
        if(v instanceof Button){
            Button btn = (Button)v;
            AnimalTypes player = AnimalTypes.getType(btn.getText().toString());
            AnimalTypes computer = computerPlayer();
            boolean result = fight(player, computer);
            new AlertDialog.Builder(this)
                    .setMessage(result? "You Win !!!\n"+getMessage(player, computer):"You Lose!!!\n"+getMessage(player, computer))
                    .setCancelable(true)
                    .create()
                    .show();
        }
    }

    private AnimalTypes computerPlayer(){
        return AnimalTypes.values()[(int)(Math.random()*1000) % 3];
    }

    private boolean fight(AnimalTypes player,AnimalTypes computer){
        switch(player){
            case RAT:
                return computer == AnimalTypes.ELEPHANT;
            case CAT:
                return computer == AnimalTypes.RAT;
            case ELEPHANT:
                return computer == AnimalTypes.CAT;
        }
        return false;
    }

    private String getMessage(AnimalTypes player,AnimalTypes computer){
        switch(player){
            case RAT:
                return computer == AnimalTypes.ELEPHANT?"Your Rat defeated Computer's Elephant":"Computer's Cat killed your Rat";
            case CAT:
                return computer == AnimalTypes.RAT?"Your Cat killed Computer's Rat":"Computer's Elephant squashed your Cat";
            case ELEPHANT:
                return computer == AnimalTypes.CAT?"Your Elephant squashed Computer's Cat":"Computer's Rat defeated your Elephant";
        }
        return  null;
    }
}

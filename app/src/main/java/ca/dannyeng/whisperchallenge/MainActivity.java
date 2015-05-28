package ca.dannyeng.whisperchallenge;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.os.CountDownTimer;
import android.app.Activity;

public class MainActivity extends ActionBarActivity {


    ImageButton start;
    TextView timer;
    Boolean clicked = false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        //title button that brings you to the info page
        ImageButton pushhow = (ImageButton)findViewById(R.id.imageButton2);

        pushhow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(),how.class);
                startActivity(i2);
            }
        });

        //Dispays the category name
        final TextView textOne = (TextView)findViewById(R.id.textView1);

        // the random button use to pick category of food
        // image is grubit_title2
        //ImageButton pushMe2 =(ImageButton)findViewById(R.id.imageButton);


        //category of food (need to finish)
        final String[] myNames = {
                "I have a pet monkey.",
                "I think I have diarrhea but I ran out of toilet paper.",
                "My booty is so fine and juicy, it makes the boys go crazy.",
                "I have a lactating nipple.","Spare some change.",
                "Sometimes when I am alone, I like to look in the mirror and laugh.",
                "I like big butts and I cannot lie.","I like to eat dog and cat food.",
                "I think I am too good looking.",
                "My main purpose in life is to eat well and shit nicely.",
                "Sometimes when I am sad I like to eat sour ice cream.",
                "Double Trouble","I poop my pants and I cannot lie.",
                "I like to drink pee and eat smelly poop.",
                "Sometimes when I am by myself, I like to eat a lot of ice cream naked.",
                "My feet smells so much that I almost fainted.","I am a thug.",
                "I believe I am the god of fart bombs.",
                "My fart smells so bad that one time I killed a squirrel.",
                "Sometimes I like to pick my butt and smell it just for fun!",
                "Is it okay to pick my butt and eat chicken wings without washing my hands?",
                "Live the life of a thug with your pants on the ground.",
                "I like to pick my nose and lick my armpit.",
                "In my spare time, I like to run around naked in my house.",
                "Hey there boo boo.",
                "Your mom is so beautiful and kind.",
                "I hate it when I fart and a little extra comes out.",
                "Your fart smells so bad that it almost made me puke my lunch.",
                "My dream is to be the world's ugliest man.","The super smelly snake bit a tiny little mouse.","Once I kissed a wild pig and it tasted like bacon.","I don't like to dance but when I do, I like to shake my butt.","I like to smell sweaty people's armpits.","I am a thug that lives the thug life.","When I stand up and pee, I don't lift up the seat.","My super powers are good looks because look at me.","I wish I had a bigger butt so i can twerk.","The crazy chicken can climb crazily high.","The foxy frog fought the frightened fish.","I want a pet polar bear so I can ride him to school.","I wear a polka dot underwear and don't like to wash it.","I like to shave my hairy legs and glue them onto my armpit.","My favourite show is Teletubbies.","I have a crush on someone in the mirror.","Can I get a Big Mac with large fries?","I like to play basketball with no ball.","Marco Polo","Just Do It.","You are my boo boo.","Cutie Patootie!","Smarty Pants","Too cool for school.","Chicken Fried Rice","Curry in a Hurry","You are Super Duper.","Taco Tuesday","Mango Pineapple Smoothie","Bootylicious","I like turtles.","Start from the bottom.","Google it.","Breaking Bad.","Young Money","Kiss my butt.","Talk to the hand.","Who let the dogs out?","Nipple Twister","Twerk it","Hit and Run.","Drop the beat.","Teach Me How to Dougie.","Five Alive.","Ice Cream Sandwich.","I love New York.","Oops I did it again.","Call me.","Hot Wheels","Sleep tight.","YOLO", "Catch Me If You Can.", "Shake your booty!", "Good looking.", "Oh No.", "The Great Wall of China.", "Lets go party!", "I just want to have fun.", "Hot Dog Buns","Dance Dance Revolution","Cat and Mouse","Ben and Jerry","Taco Bell","I don't shower.","I need to pee.","I am broke.","I am ugly.","I shit my pants.","Touch my body.","You look weird.","I can fly.","That shit cray.", "Baby Baby Baby" };


        start = (ImageButton)findViewById(R.id.imageButton);
        timer  = (TextView)findViewById(R.id.timer);
        timer.setText("60"); // starting from 30.

        final MyCounter timer = new MyCounter(60000,1000);

        start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clicked){
                    timer.start();
                    clicked = true;
                }

                int rando1 = (int)(Math.random()*myNames.length);
                textOne.setText(myNames[rando1]);
            }
        });

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }

    public class MyCounter extends CountDownTimer{

        public MyCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            System.out.println("Game Over Bro.");
            timer.setText("Game Over Bro.");
            clicked = false;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            timer.setText((millisUntilFinished/1000)+"");
            System.out.println("Timer  : " + (millisUntilFinished/1000));
        }
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
}

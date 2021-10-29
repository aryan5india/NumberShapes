package com.aryanvedh.numbershapes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;

        public boolean isTriangular() {
            int x = 1;
            int tringNum = 1;

            while (tringNum < number) {
                x++;
                tringNum = tringNum + x;
/*               1 = 1 + 2 = 3
                3 = 3 + 3 = 6
                6 = 6 + 4 = 10
                10 = 10 + 5 = 15
                15 = 15+6 = 21
 */
            }

            return tringNum == number;
        }

        public boolean isSquare() {

            double squreRoot = Math.sqrt(number);

            return squreRoot == Math.floor(squreRoot);
        }
    } // Number class ends here!

    public void check(View view) {

        TextView textView2 = findViewById(R.id.textView2);
        textView2.animate().translationX(1000f).setDuration(2000);

        EditText userNumber = findViewById(R.id.numberField);

//        ImageView car = findViewById(R.id.car);
//        car.animate().translationX(2000f).setDuration(4000).setStartDelay(1000);
//        car.animate().scaleXBy(1f).setDuration(1000);


        if (userNumber.getText().toString().isEmpty()) {
            userNumber.setError("Please enter a number");
        } else {
            Number myNumber = new Number();

            myNumber.number = Integer.parseInt(userNumber.getText().toString());

            String message = "";

            if (myNumber.isSquare() && myNumber.isTriangular()){
                message = myNumber.number + " is both square and triangular number!";
            } else if(myNumber.isSquare()) {
                message = myNumber.number + " is square but not triangular!";
            } else if(myNumber.isTriangular()){
                message = myNumber.number + " is triangular but not square number!";
            } else {
                message = myNumber.number + " is neither square nor triangular!";
            }

//            if (myNumber.isSquare()) {
//                if (myNumber.isTriangular()) {
//                    message = myNumber.number + " is both square and triangular number!";
//                } else {
//                    message = myNumber.number + " is square but not triangular!";
//                }
//            } else {
//                if (myNumber.isTriangular()) {
//                    message = myNumber.number + " is triangular but not square number!";
//                } else {
//                    message = myNumber.number + " is neither square nor triangular!";
//                }
//            }
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
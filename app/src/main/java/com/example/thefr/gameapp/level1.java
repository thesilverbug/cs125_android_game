package com.example.thefr.gameapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class level1 extends View {

    private boolean movingPlayer = false;

    int flow = 0;
    boolean check = true;

    private Bitmap person[] = new Bitmap[2];
    private Bitmap darkness;
    private Bitmap poop;
    private Bitmap dog;

    private int darkX;
    private int darkY;
    private int personX;
    private int personY;


    private int canvasWidth, canvasHeight;

    private int yellowX, yellowY;
    private Paint yellowPaint = new Paint();

    private int greenX, greenY;
    private Paint greenPaint = new Paint();

    private int redX, redY, redSpeed = 25;
    private Paint redPaint = new Paint();

    private int blueX, blueY;
    private Paint bluePaint = new Paint();

    private int score, lifeCounter;

//    private boolean touch = false;

    private Bitmap backgroundImage;


    public level1(Context context) {
        super(context);

        person[0] = BitmapFactory.decodeResource(getResources(), R.drawable.char1);
        person[1] = BitmapFactory.decodeResource(getResources(), R.drawable.char2);
        darkness = BitmapFactory.decodeResource(getResources(), R.drawable.darkness);
        poop = BitmapFactory.decodeResource(getResources(), R.drawable.poop);
        dog = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        backgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.background);


        yellowPaint.setColor(Color.TRANSPARENT);
        yellowPaint.setAntiAlias(false);

        greenPaint.setColor(Color.TRANSPARENT);
        greenPaint.setAntiAlias(false);

        redPaint.setColor(Color.TRANSPARENT);
        redPaint.setAntiAlias(false);

        bluePaint.setColor(Color.BLUE);
        bluePaint.setAntiAlias(false);


        personX = 740-person[0].getWidth()/2;
        personY = 1500-person[0].getHeight()/2;
        darkX = 740-darkness.getWidth()/2;
        darkY = 1500-darkness.getHeight()/2;
        //score = 0;
        lifeCounter = 1;

        greenX = 300;
        greenY = 900;

        yellowX = 400;
        yellowY = 400;

        blueX = 50;
        blueY = 50;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(backgroundImage, 0, 0, null);




        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();


//        canvas.drawBitmap(backgroundImage, 0, 0, null);
//
        int minPersonY = person[0].getHeight();
        int maxPersonY = canvasHeight - person[0].getHeight() * 3;

        canvas.drawCircle(blueX, blueY, 60, bluePaint);
        if (hitBallChecker(blueX, blueY, 30, 30) && check) {
            check = false;
            Toast.makeText(getContext(), "Level1 Clear", Toast.LENGTH_SHORT).show();

            Intent nextLevel = new Intent(getContext(), Main2Activity.class);
            nextLevel.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            getContext().startActivity(nextLevel);
        }


        canvas.drawBitmap(poop, yellowX - poop.getWidth()/2, yellowY - poop.getHeight()/2, null);
        canvas.drawCircle(yellowX, yellowY, 60, yellowPaint);
        if (hitBallChecker(yellowX, yellowY, 30, 30)) {
            lifeCounter--;
            yellowX = -100;
            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOver1.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }

        canvas.drawBitmap(dog, greenX - dog.getWidth()/2, greenY - dog.getHeight()/2, null);
        canvas.drawCircle(greenX, greenY, 100, greenPaint);
        if (hitBallChecker(greenX, greenY, 50, 50)) {
            lifeCounter--;
            greenX = -100;
            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOver1.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }


        redX = redX - redSpeed/100;
        if (hitBallChecker(redX, redY, 15, 15)) {
            lifeCounter--;
            redX = -100;
        }
        if (redX < 0) {
            redX = canvasWidth + 21;
            redY = (int) Math.floor(Math.random() * (maxPersonY - minPersonY)) + minPersonY;
        }
        canvas.drawCircle(redX, redY, 30, redPaint);

        if (flow > 4) {
            flow = 0;
        }
        if (flow > 2) {
            canvas.drawBitmap(person[1], personX, personY, null);
        } else {
            canvas.drawBitmap(person[0], personX, personY, null);
        }
        flow++;

        canvas.drawBitmap(darkness, darkX, darkY, null);
    }
//
    public boolean hitBallChecker(int x, int y, int width, int height) {
        if (personX < x+width && x-width < (personX + person[0].getWidth()) && personY + 200 < y+height && y-height < (personY + person[0].getHeight())) {
            return true;
        }
        return false;
    }
    public boolean chaClicker(int x, int y, int width, int height) {
        if (personX < x + width && x - width < (personX + person[0].getWidth()) && personY < y + height && y - height < (personY + person[0].getHeight())) {
            return true;
        }
        return false;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (chaClicker((int) event.getX(), (int) event.getY(), 0, 0)) {
                    movingPlayer = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (movingPlayer) {
                    personX = (int) event.getX() - person[0].getWidth() / 2;
                    personY = (int) event.getY() - person[0].getHeight() / 2;
                    darkX = (int) event.getX() - darkness.getWidth() / 2;
                    darkY = (int) event.getY() - darkness.getHeight() / 2;
                }
                break;
            case MotionEvent.ACTION_UP:
                movingPlayer = false;
                break;
        }


        return true;
    }

}


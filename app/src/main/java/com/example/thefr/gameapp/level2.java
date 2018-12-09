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

public class level2 extends View {

    private boolean movingPlayer = false;

    int flow = 0;
    boolean check = true;

    private Bitmap person[] = new Bitmap[2];
    private Bitmap darkness;
    private Bitmap fence;
    private Bitmap bar;
    private Bitmap h_bar;


    private int darkX;
    private int darkY;
    private int personX;
    private int personY;
//    private int fishSpeed;

    private int canvasWidth, canvasHeight;

//    private int yellowX, yellowY;
//    private Paint yellowPaint = new Paint();
//
//    private int greenX, greenY;
//    private Paint greenPaint = new Paint();
//
//    private int redX, redY, redSpeed = 25;
//    private Paint redPaint = new Paint();

    private int blueX, blueY;
    private Paint bluePaint = new Paint();

    private int lifeCounter;

//    private boolean touch = false;

    private Bitmap backgroundImage;
//    private Paint scorePaint = new Paint();
//    private Bitmap life[] = new Bitmap[2];

    public level2(Context context) {
        super(context);

        person[0] = BitmapFactory.decodeResource(getResources(), R.drawable.char1);
        person[1] = BitmapFactory.decodeResource(getResources(), R.drawable.char2);
        darkness = BitmapFactory.decodeResource(getResources(), R.drawable.darkness);
        fence = BitmapFactory.decodeResource(getResources(), R.drawable.fence);
        bar = BitmapFactory.decodeResource(getResources(), R.drawable.bar);
        h_bar = BitmapFactory.decodeResource(getResources(), R.drawable.h_bar);

        backgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.background2);


//        yellowPaint.setColor(Color.TRANSPARENT);
//        yellowPaint.setAntiAlias(false);
//
//        greenPaint.setColor(Color.TRANSPARENT);
//        greenPaint.setAntiAlias(false);
//
//        redPaint.setColor(Color.TRANSPARENT);
//        redPaint.setAntiAlias(false);

        bluePaint.setColor(Color.BLUE);
        bluePaint.setAntiAlias(false);


        personX = 140-person[0].getWidth()/2;
        personY = 150-person[0].getHeight()/2;
        darkX = 140-darkness.getWidth()/2;
        darkY = 150-darkness.getHeight()/2;
        //score = 0;
        lifeCounter = 2;

//        greenX = 300;
//        greenY = 900;
//
//        yellowX = 400;
//        yellowY = 400;

        blueX = 50;
        blueY = 1800;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(backgroundImage, 0, -70, null);

        if (flow > 4) {
            flow = 0;
        }
        if (flow > 2) {
            canvas.drawBitmap(person[1], personX, personY, null);
        } else {
            canvas.drawBitmap(person[0], personX, personY, null);
        }
        flow++;

        canvas.drawBitmap(fence, 0, -70, null);

        canvas.drawBitmap(bar, -125, 380, null);
        if (hitBallChecker(-125+bar.getWidth()/2, 380+bar.getHeight()/2, 320, 2)) {
            lifeCounter--;

            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOver1.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }
        canvas.drawBitmap(bar, 800, 380, null);
        if (hitBallChecker(800+bar.getWidth()/2, 380+bar.getHeight()/2, 320, 2)) {
            lifeCounter--;

            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOver1.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }
        canvas.drawBitmap(bar, 208, 740, null);
        if (hitBallChecker(208+bar.getWidth()/2, 740+bar.getHeight()/2, 320, 2)) {
            lifeCounter--;

            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOver1.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }
        canvas.drawBitmap(bar, 208, 1100, null);
        if (hitBallChecker(208+bar.getWidth()/2, 1100+bar.getHeight()/2, 320, 2)) {
            lifeCounter--;

            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOver1.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }
        canvas.drawBitmap(bar, -45, 1460, null);
        if (hitBallChecker(-45+bar.getWidth()/2, 1460+bar.getHeight()/2, 320, 2)) {
            lifeCounter--;

            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOver1.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }
        canvas.drawBitmap(h_bar, 893, 760, null);
        if (hitBallChecker(893+h_bar.getWidth()/2, 760+h_bar.getHeight()/2, 1, 550)) {
            lifeCounter--;

            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOver1.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }



        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();


//
        int minPersonY = person[0].getHeight();
        int maxPersonY = canvasHeight - person[0].getHeight() * 3;

        canvas.drawCircle(blueX, blueY, 60, bluePaint);

        if (hitBallChecker(blueX, blueY, 30, 30) && check) {
            check = false;
            Toast.makeText(getContext(), "Level2 Clear", Toast.LENGTH_SHORT).show();

            Intent gameOverIntent = new Intent(getContext(), Main3Activity.class);
            gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            getContext().startActivity(gameOverIntent);
        }


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
        if (personX < x+width && x-width < (personX + person[0].getWidth()) && personY < y+height && y-height < (personY + person[0].getHeight())) {
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


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
    private Bitmap darkness[] = new Bitmap[2];
    private Bitmap fence;
    private Bitmap bar;
    private Bitmap h_bar;
    private Bitmap flash;


    private int darkX;
    private int darkY;
    private int personX;
    private int personY;


    protected static boolean flashLight;

    private int fence1_x;
    private int fence1_y;
    private int fence2_x;
    private int fence2_y;
    private int fence3_x;
    private int fence3_y;
    private int fence4_x;
    private int fence4_y;
    private int fence5_x;
    private int fence5_y;
    private int fence6_x;
    private int fence6_y;

//    private int yellowX, yellowY;
//    private Paint yellowPaint = new Paint();
//
//    private int greenX, greenY;
//    private Paint greenPaint = new Paint();
//
    private int redX, redY, redSpeed;
    private Paint redPaint = new Paint();

    private int blueX, blueY;
    private Paint bluePaint = new Paint();

    private int lifeCounter;

//    private boolean touch = false;

    private Bitmap backgroundImage;
//    private Paint scorePaint = new Paint();


    public level2(Context context) {
        super(context);

        person[0] = BitmapFactory.decodeResource(getResources(), R.drawable.char1);
        person[1] = BitmapFactory.decodeResource(getResources(), R.drawable.char2);
        darkness[0] = BitmapFactory.decodeResource(getResources(), R.drawable.darkness);
        darkness[1] = BitmapFactory.decodeResource(getResources(), R.drawable.darkness_flashlight);
        fence = BitmapFactory.decodeResource(getResources(), R.drawable.fence_2);
        bar = BitmapFactory.decodeResource(getResources(), R.drawable.bar_tran);
        h_bar = BitmapFactory.decodeResource(getResources(), R.drawable.h_bar_tran);
        flash = BitmapFactory.decodeResource(getResources(), R.drawable.flashlight);
        backgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.background22);


        bluePaint.setColor(Color.BLUE);
        bluePaint.setAntiAlias(false);

        redPaint.setColor(Color.TRANSPARENT);
        redPaint.setAntiAlias(false);


        personX = 140-person[0].getWidth()/2;
        personY = 150-person[0].getHeight()/2;
        darkX = 140-darkness[0].getWidth()/2;
        darkY = 150-darkness[0].getHeight()/2;

        if (level1.flashLight) {
            flashLight = true;
        } else {
            flashLight = false;
        }

        lifeCounter = 1;


        fence1_x = -150;
        fence1_y = 320;
        fence2_x = 800;
        fence2_y = 320;
        fence3_x = 208;
        fence3_y = 685;
        fence4_x = 208;
        fence4_y = 1050;
        fence5_x = -140;
        fence5_y = 1420;
        fence6_x = 820;
        fence6_y = 710;

        blueX = 50;
        blueY = 1600;

        redX = 550;
        redY = 870;


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(backgroundImage, 0, -40, null);
        if (flow > 4) {
            flow = 0;
        }
        if (flow > 2) {
            canvas.drawBitmap(person[1], personX, personY, null);
        } else {
            canvas.drawBitmap(person[0], personX, personY, null);
        }
        flow++;
        canvas.drawBitmap(fence, 0, -40, null);

        canvas.drawBitmap(bar, fence1_x, fence1_y, null);
        if (hitBallChecker(fence1_x+bar.getWidth()/2, fence1_y+bar.getHeight()/2, bar.getWidth()/2, 1)) {
            lifeCounter--;

            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOverFence.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }
        canvas.drawBitmap(bar, fence2_x, fence2_y, null);
        if (hitBallChecker(fence2_x+bar.getWidth()/2, fence2_y+bar.getHeight()/2, bar.getWidth()/2, 1)) {
            lifeCounter--;

            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOverFence.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }
        canvas.drawBitmap(bar, fence3_x, fence3_y, null);
        if (hitBallChecker(fence3_x+bar.getWidth()/2, fence3_y+bar.getHeight()/2, bar.getWidth()/2, 1)) {
            lifeCounter--;

            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOverFence.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }
        canvas.drawBitmap(bar, fence4_x, fence4_y, null);
        if (hitBallChecker(fence4_x+bar.getWidth()/2, fence4_y+bar.getHeight()/2, bar.getWidth()/2, 1)) {
            lifeCounter--;

            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOverFence.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }
        canvas.drawBitmap(bar, fence5_x, fence5_y, null);
        if (hitBallChecker(fence5_x+bar.getWidth()/2, fence5_y+bar.getHeight()/2, bar.getWidth()/2, 1)) {
            lifeCounter--;

            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOverFence.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }
        canvas.drawBitmap(h_bar, fence6_x, fence6_y, null);
        if (hitBallChecker(fence6_x+h_bar.getWidth()/2, fence6_y+h_bar.getHeight()/2, h_bar.getWidth()/2, h_bar.getHeight()/2)) {
            lifeCounter--;

            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOverFence.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }




        canvas.drawCircle(blueX, blueY, 60, bluePaint);

        if (hitBallChecker(blueX, blueY, 30, 30) && check && lifeCounter > 0) {
            check = false;
            Toast.makeText(getContext(), "Level2 Clear", Toast.LENGTH_SHORT).show();

            Intent gameOverIntent = new Intent(getContext(), Main3Activity.class);
            gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            getContext().startActivity(gameOverIntent);
        }

        if (hitBallChecker(redX, redY, 15, 15)) {
            redX = -100;
            flashLight = true;
        }
        canvas.drawBitmap(flash, redX - flash.getWidth()/2, redY - flash.getHeight()/2, null);
        canvas.drawCircle(redX, redY, 30, redPaint);



        if (!flashLight) {
            canvas.drawBitmap(darkness[0], darkX, darkY, null);
        } else {
            canvas.drawBitmap(darkness[1], darkX, darkY, null);
        }

    }
    //
    public boolean hitBallChecker(int x, int y, int width, int height) {
        if (personX < x+width && x-width < (personX + person[0].getWidth()*9/10) && personY < y+height && y-height < (personY + person[0].getHeight())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (hitBallChecker((int) event.getX(), (int) event.getY(), 0, 0)) {
                    movingPlayer = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (movingPlayer) {
                    personX = (int) event.getX() - person[0].getWidth() / 2;
                    personY = (int) event.getY() - person[0].getHeight() / 2;
                    darkX = (int) event.getX() - darkness[0].getWidth() / 2;
                    darkY = (int) event.getY() - darkness[0].getHeight() / 2;
                }
                break;
            case MotionEvent.ACTION_UP:
                movingPlayer = false;
                break;
        }


        return true;
    }

}


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
    /**
     * Counting time interval. It act as a trigger for loading different image, creating animation effect.
     */
    int timeCount = 0;
    /**
     * Check whether character reach portal once.
     */
    boolean portalCheck = true;
    /**
     * Variable that store image from drawable.
     */
    private Bitmap person[] = new Bitmap[2];
    private Bitmap darkness[] = new Bitmap[2];
    private Bitmap poop;
    private Bitmap dog;
    private Bitmap flash;
    private Bitmap backgroundImage;
    /**
     * Coordinate variable for character.
     */
    private int darkX;
    private int darkY;
    private int personX;
    private int personY;
    /**
     * Coordinate variable for obstacle and portal(blue).
     */
    private int yellowX, yellowY;
    private Paint yellowPaint = new Paint();
    private int yellow2X, yellow2Y;
    private int yellow3X, yellow3Y;


    private int greenX, greenY;
    private Paint greenPaint = new Paint();

    private int redX, redY;
    private Paint redPaint = new Paint();

    private int blueX, blueY;
    private Paint bluePaint = new Paint();

    /**
     * Number of life in this game. if life reach 0, game will be over.
     */
    private int lifeCounter;
    /**
     * Checking whether user have special item, flash light.
     */
    protected static boolean flashLight;


    /**
     * Constructor for level1. It define all the variable that will be use.
     * @param context
     */
    public level1(Context context) {
        super(context);
        /**
         * Assign image to each variable.
         */
        person[0] = BitmapFactory.decodeResource(getResources(), R.drawable.char1);
        person[1] = BitmapFactory.decodeResource(getResources(), R.drawable.char2);
        darkness[0] = BitmapFactory.decodeResource(getResources(), R.drawable.darkness);
        darkness[1] = BitmapFactory.decodeResource(getResources(), R.drawable.darkness_flashlight);
        poop = BitmapFactory.decodeResource(getResources(), R.drawable.poop);
        dog = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        backgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        flash = BitmapFactory.decodeResource(getResources(), R.drawable.flashlight);

        /**
         * Set visibility of obstacle hit checkers.
         */
        yellowPaint.setColor(Color.TRANSPARENT);
        yellowPaint.setAntiAlias(false);


        greenPaint.setColor(Color.TRANSPARENT);
        greenPaint.setAntiAlias(false);

        redPaint.setColor(Color.TRANSPARENT);
        redPaint.setAntiAlias(false);

        bluePaint.setColor(Color.BLUE);
        bluePaint.setAntiAlias(false);


        /**
         * initial coordinate for character.
         */
        personX = 740-person[0].getWidth()/2;
        personY = 1500-person[0].getHeight()/2;
        darkX = 740-darkness[0].getWidth()/2;
        darkY = 1500-darkness[0].getHeight()/2;
        /**
         * initial access to flash light.
         */
        flashLight = false;
        /**
         * number of life given.
         */
        lifeCounter = 1;

        /**
         * initial coordinate for obstacles.
         */
        greenX = 300;
        greenY = 900;

        yellowX = 400;
        yellowY = 400;
        yellow2X = 900;
        yellow2Y = 800;
        yellow3X = 550;
        yellow3Y = 1200;

        blueX = 50;
        blueY = 50;

        redX = 3200;
        redY = 1400;
    }

    /**
     * Where coding and image meet. upload and update image by time interval given from MainActivity.
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * Set background first, so all other images would be front.
         */
        canvas.drawBitmap(backgroundImage, 0, 0, null);
        /**
         * Setting trigger for image change in character.
         */
        if (timeCount > 4) {
            timeCount = 0;
        }
        if (timeCount > 2) {
            canvas.drawBitmap(person[1], personX, personY, null);
        } else {
            canvas.drawBitmap(person[0], personX, personY, null);
        }
        timeCount++;

        /**
         * create portal.
         */
        canvas.drawCircle(blueX, blueY, 60, bluePaint);
        /**
         * When character hit portal, go to next level.
         */
        if (hitBallChecker(blueX, blueY, 30, 30) && portalCheck && lifeCounter > 0) {
            portalCheck = false;
            Toast.makeText(getContext(), "Level1 Clear", Toast.LENGTH_SHORT).show();

            Intent nextLevel = new Intent(getContext(), Main2Activity.class);
            nextLevel.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            getContext().startActivity(nextLevel);
        }

        /**
         * create obstacle poop and hit checker for poop.
         */
        canvas.drawBitmap(poop, yellowX - poop.getWidth()/2, yellowY - poop.getHeight()/2, null);
        canvas.drawCircle(yellowX, yellowY, 60, yellowPaint);
        canvas.drawBitmap(poop, yellow2X - poop.getWidth()/2, yellow2Y - poop.getHeight()/2, null);
        canvas.drawCircle(yellow2X, yellow2Y, 60, yellowPaint);
        canvas.drawBitmap(poop, yellow3X - poop.getWidth()/2, yellow3Y - poop.getHeight()/2, null);
        canvas.drawCircle(yellow3X, yellow3Y, 60, yellowPaint);
        /**
         * if character hit hit checker for poop, goto GameOverPoop activity.
         */
        if (hitBallChecker(yellowX, yellowY, 30, 30) || hitBallChecker(yellow2X, yellow2Y, 30, 30)|| hitBallChecker(yellow3X, yellow3Y, 30, 30)) {
            lifeCounter--;
            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOverPoop.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }
        /**
         * create obstacle dog and its hit checker.
         */
        canvas.drawBitmap(dog, greenX - dog.getWidth()/2, greenY - dog.getHeight()/2, null);
        canvas.drawCircle(greenX, greenY, 100, greenPaint);
        /**
         * if character hit hit checker for dog, go to GameOverDog activity.
         */
        if (hitBallChecker(greenX, greenY, 50, 50)) {
            lifeCounter--;
            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOverDog.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }
        /**
         * create flash light and its hit checker.
         */
        canvas.drawBitmap(flash, redX - flash.getWidth()/2, redY - flash.getHeight()/2, null);
        canvas.drawCircle(redX, redY, 30, redPaint);
        /**
         * if character hit flash light hit checker, update the flash light owning status.
         */
        if (hitBallChecker(redX, redY, 15, 15)) {
            redX = -100;
            flashLight = true;
        }
        /**
         * Flash light ownership checker. Depend on the result, range that character could see will vary.
         */
        if (flashLight == false) {
            canvas.drawBitmap(darkness[0], darkX, darkY, null);
        } else {
            canvas.drawBitmap(darkness[1], darkX, darkY, null);
        }
    }

    /**
     * hit checker for any object.
     * @param x Object's x coordinate.
     * @param y Object's y coordinate.
     * @param width Object's half width.
     * @param height Object's half height.
     * @return return true if object is touching character, else return false.
     */
    public boolean hitBallChecker(int x, int y, int width, int height) {
        if (personX < x+width && x-width < (personX + person[0].getWidth()) && personY < y+height && y-height < (personY + person[0].getHeight())) {
            return true;
        }
        return false;
    }

    /**
     * Set up the click and drag feature for moving character. character will only more when user
     * click within acceptable range from character. Character will only move when user press down
     * on character.
     * @param event
     * @return
     */
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


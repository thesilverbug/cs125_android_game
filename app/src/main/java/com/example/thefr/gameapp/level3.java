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

public class level3 extends View {

    private boolean movingPlayer = false;

    int flow = 0;
    boolean check = true;

    private Bitmap person[] = new Bitmap[2];
    private Bitmap darkness[] = new Bitmap[2];
    private Bitmap ghost[] = new Bitmap[4];
    private Bitmap road;



    private int darkX;
    private int darkY;
    private int personX;
    private int personY;


    private int yellowX, yellowY, yellowSpeed = 20;
    private Paint yellowPaint = new Paint();

    private int greenX, greenY, greenSpeed = 20;
    private Paint greenPaint = new Paint();

    private int redX, redY, redSpeed = 30;
    private Paint redPaint = new Paint();

    private int blueX, blueY;
    private Paint bluePaint = new Paint();

    private int lifeCounter;
    protected static boolean flashLight;

    private boolean turn1 = true;
    private boolean turn2 = true;



    private Bitmap backgroundImage;


    public level3(Context context) {
        super(context);

        person[0] = BitmapFactory.decodeResource(getResources(), R.drawable.char1);
        person[1] = BitmapFactory.decodeResource(getResources(), R.drawable.char2);
        darkness[0] = BitmapFactory.decodeResource(getResources(), R.drawable.darkness);
        darkness[1] = BitmapFactory.decodeResource(getResources(), R.drawable.darkness_flashlight);
        ghost[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ghost_front1);
        ghost[1] = BitmapFactory.decodeResource(getResources(), R.drawable.ghost_front2);
        ghost[2] = BitmapFactory.decodeResource(getResources(), R.drawable.ghost_back1);
        ghost[3] = BitmapFactory.decodeResource(getResources(), R.drawable.ghost_back2);
        road = BitmapFactory.decodeResource(getResources(), R.drawable.road_tran);


        backgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.background3);


        yellowPaint.setColor(Color.TRANSPARENT);
        yellowPaint.setAntiAlias(false);

        greenPaint.setColor(Color.TRANSPARENT);
        greenPaint.setAntiAlias(false);

        redPaint.setColor(Color.TRANSPARENT);
        redPaint.setAntiAlias(false);

        bluePaint.setColor(Color.BLUE);
        bluePaint.setAntiAlias(false);


        personX = 80-person[0].getWidth()/2;
        personY = 1500-person[0].getHeight()/2;
        darkX = 80-darkness[0].getWidth()/2;
        darkY = 1500-darkness[0].getHeight()/2;
        if (level2.flashLight) {
            flashLight = true;
        } else {
            flashLight = false;
        }
        lifeCounter = 1;

        greenX = 700;
        greenY = 1700;

        yellowX = 400;
        yellowY = 1100;

        redX = 560;
        redY = 800;

        blueX = 970;
        blueY = 800;
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







        canvas.drawBitmap(road, 0, 0, null);
        if (hitBallChecker(road.getWidth()/2, road.getHeight()/2, road.getWidth()/2, road.getHeight()/2)) {
            lifeCounter--;
            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOverBus.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }

        canvas.drawCircle(redX, redY, 60, redPaint);
        if (hitBallChecker(redX, redY, 30, 30)) {
            lifeCounter--;
            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOverHole.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }


        if (yellowY > 1700) {
            turn1 = false;
        }
        if (yellowY < 1100) {
            turn1 = true;
        }
        if (turn1) {
            yellowY = yellowY + yellowSpeed;
        } else {
            yellowY = yellowY - yellowSpeed;
        }

        if (flow > 2) {
            if (turn1) {
                canvas.drawBitmap(ghost[0], yellowX - ghost[0].getWidth()/2, yellowY - ghost[0].getHeight()/2, null);
            } else {
                canvas.drawBitmap(ghost[2], yellowX - ghost[0].getWidth()/2, yellowY - ghost[0].getHeight()/2, null);
            }
        } else {
            if (turn1) {
                canvas.drawBitmap(ghost[1], yellowX - ghost[0].getWidth()/2, yellowY - ghost[0].getHeight()/2, null);
            } else {
                canvas.drawBitmap(ghost[3], yellowX - ghost[0].getWidth()/2, yellowY - ghost[0].getHeight()/2, null);
            }
        }
        canvas.drawCircle(yellowX, yellowY, 50, yellowPaint);
        if (hitBallChecker(yellowX, yellowY, 30, 30)) {
            lifeCounter--;
            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOver1.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }



        if (greenY > 1700) {
            turn2 = false;
        }
        if (greenY < 1100) {
            turn2 = true;
        }
        if (turn2) {
            greenY = greenY + greenSpeed;
        } else {
            greenY = greenY - greenSpeed;
        }

        if (flow > 2) {
            if (turn2) {
                canvas.drawBitmap(ghost[0], greenX - ghost[0].getWidth()/2, greenY - ghost[0].getHeight()/2, null);
            } else {
                canvas.drawBitmap(ghost[2], greenX - ghost[0].getWidth()/2, greenY - ghost[0].getHeight()/2, null);
            }
        } else {
            if (turn2) {
                canvas.drawBitmap(ghost[1], greenX - ghost[0].getWidth()/2, greenY - ghost[0].getHeight()/2, null);
            } else {
                canvas.drawBitmap(ghost[3], greenX - ghost[0].getWidth()/2, greenY - ghost[0].getHeight()/2, null);
            }
        }
        canvas.drawCircle(greenX, greenY, 50, greenPaint);
        if (hitBallChecker(greenX, greenY, 30, 30)) {
            lifeCounter--;
            if (lifeCounter == 0) {

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOver1.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getContext().startActivity(gameOverIntent);

            }
        }


        canvas.drawCircle(blueX, blueY, 60, bluePaint);

        if (hitBallChecker(blueX, blueY, 30, 30) && check && lifeCounter > 0) {
            check = false;
            Toast.makeText(getContext(), "Level3 Clear", Toast.LENGTH_SHORT).show();

            Intent gameOverIntent = new Intent(getContext(), Main4Activity.class);
            gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            getContext().startActivity(gameOverIntent);
        }




        if (!flashLight) {
            canvas.drawBitmap(darkness[0], darkX, darkY, null);
        } else {
            canvas.drawBitmap(darkness[1], darkX, darkY, null);
        }

    }
    //
    public boolean hitBallChecker(int x, int y, int width, int height) {
        if (personX < x+width && x-width < (personX + person[0].getWidth()) && personY < y+height && y-height < (personY + person[0].getHeight())) {
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


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



public class gameClear extends View {







    int flow = 0;

    private Bitmap backgroundImage;

    private Bitmap credit;

    private Bitmap button;

    private Bitmap ending;





    private int buttonX, buttonY;

    private int creditY;





    public gameClear(Context context) {

        super(context);







        backgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.black);

        credit = BitmapFactory.decodeResource(getResources(), R.drawable.credit);

        ending = BitmapFactory.decodeResource(getResources(), R.drawable.ending);

        button = BitmapFactory.decodeResource(getResources(), R.drawable.menu);



        creditY = 1000;

        buttonX = 0;

        buttonY = -500;





    }



    @Override

    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);



        canvas.drawBitmap(backgroundImage, 0, 0, null);

        canvas.drawBitmap(credit,0, creditY, null);

        canvas.drawBitmap(ending,0,0,null);

        canvas.drawBitmap(button,buttonX,buttonY,null);

        if (flow > 70 && creditY > -400) {

            creditY -= 5;

        }

        flow++;

        if (flow > 400) {

            buttonY = 1500;

        }

    }



    public boolean hitBallChecker(int x, int y, int width, int height) {

        if (buttonX < x+width && x-width < (buttonX + button.getWidth()) && buttonY < y+height && y-height < (buttonY + button.getHeight())) {

            return true;

        }

        return false;

    }



    @Override

    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                if (hitBallChecker((int) event.getX(), (int) event.getY(), 0, 0)) {

                    Toast.makeText(getContext(), "Main Menu", Toast.LENGTH_SHORT).show();



                    Intent gameOverIntent = new Intent(getContext(), startActivity.class);

                    gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    startActivity.bgm = null;

                    getContext().startActivity(gameOverIntent);

                }

                break;

        }

        return true;

    }



}
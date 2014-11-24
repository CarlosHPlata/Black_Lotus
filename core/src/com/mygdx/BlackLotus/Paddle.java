package com.mygdx.BlackLotus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by kingskull on 18/11/2014.
 */
public abstract class Paddle {

    public static final float SPEED = 400;

    protected Texture texture;
    protected Rectangle bordes;

    public Paddle (float x, float y){
        this.texture = new Texture(Gdx.files.internal("padle.jpg"));
        this.bordes = new Rectangle(x, y, texture.getWidth(), texture.getHeight());

    }

    public void draw(SpriteBatch batch){
        batch.draw(texture, bordes.x, bordes.y, texture.getWidth(), texture.getHeight());
    }

    public Rectangle getBorders(){
        return bordes;
    }

    public abstract void update();

    protected boolean colisionUp() {
        return (bordes.y+bordes.getHeight() >= Gdx.graphics.getHeight());
    }

    protected boolean colisionDown() {
        return bordes.y <= 0;
    }
}


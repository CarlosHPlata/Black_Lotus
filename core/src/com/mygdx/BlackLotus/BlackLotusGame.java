package com.mygdx.BlackLotus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.BlackLotus.screens.AbstractScreen;
import com.mygdx.BlackLotus.screens.GameScreen;

public class BlackLotusGame extends Game {

    public AbstractScreen GAMESCREEN;

	@Override
	public void create () {
        GAMESCREEN = new GameScreen(this);
        setScreen(GAMESCREEN);
	}

}

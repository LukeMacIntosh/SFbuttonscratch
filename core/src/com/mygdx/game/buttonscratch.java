package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class buttonscratch extends ApplicationAdapter {
    Stage stage;
    TextButton button;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;

    @Override
    public void create() {
        stage = new Stage();
        font = new BitmapFont();

        Gdx.input.setInputProcessor(stage);
        btnSkin();

        button = new TextButton("CLICK ME, SEE WHAT HAPPENS", textButtonStyle);
        button.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                System.out.println("Nothing Happens HAHAHA");
            }
        });

        button.setSize(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 4);
        button.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 4,
                Gdx.graphics.getHeight() / 2 - Gdx.graphics.getWidth() / 8);

        stage.addActor(button);
    }

    @Override
    public void render() {
        super.render();
        stage.draw();
    }

    private void btnSkin() {
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("MenuButton.pack")); // stole Matt Beemer's pack file
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("MenuButtonUp");
        textButtonStyle.down = skin.getDrawable("MenuButtonDown");
        textButtonStyle.checked = skin.getDrawable("MenuButtonUp");
    }
}
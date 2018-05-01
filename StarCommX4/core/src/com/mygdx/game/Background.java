package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Background {
    class Star {
        Vector2 position;
        float speed;

        public Star() {
            position = new Vector2(MathUtils.random(0, 1024), MathUtils.random(0, 576));
            speed = MathUtils.random(0.5f, 2.0f);
        }

        public void update() {
            position.x -= speed;
            if(position.x < 0) {
                position.x = 1024;
                position.y = MathUtils.random(0, 576);
                speed = MathUtils.random(0.5f, 2.0f);
            }
        }
    }

    private Texture imgBg;
    private Texture imgStar;
    private final int STARS_COUNT = 200;
    private Star[] stars;

    public Background() {
        imgBg = new Texture("bg.png");
        imgStar = new Texture("star12.tga");
        stars = new Star[STARS_COUNT];
        for (int i = 0; i < STARS_COUNT; i++) {
            stars[i] = new Star();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(imgBg, 0, 0);
        for (int i = 0; i < STARS_COUNT; i++) {
            float size = stars[i].speed / 2.0f;
            if (MathUtils.random(0, 50) < 1)
                size *= 1.8f;
            batch.draw(imgStar, stars[i].position.x, stars[i].position.y, 6, 6, 12, 12, size, size, 0, 0, 0, 12, 12, false, false);
            //batch.draw(imgStar, stars[i].position.x, stars[i].position.y);
        }
    }

    public void update() {
        for (int i = 0; i < STARS_COUNT; i++) {
            stars[i].update();
        }
    }
}
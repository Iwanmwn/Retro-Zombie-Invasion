package com.myowndev.invasion;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.myowndev.invasion.helpers.Assets;
import com.myowndev.invasion.helpers.Config;
import com.myowndev.invasion.levels.Survival;
import com.myowndev.invasion.states.GameState;
import com.myowndev.invasion.states.MenuState;

public class Invasion extends ApplicationAdapter {
	public static final int VIRTUAL_WIDTH = 854; // stretching is probably wont work, or should work incorrectly on screens larger than implemented size in the code
	public static final int VIRTUAL_HEIGHT = 480;
	private static final float ASPECT_RATIO = (float)VIRTUAL_WIDTH/(float)VIRTUAL_HEIGHT;
	private OrthographicCamera camera;
	private Viewport viewport;

	public static float scale = 1f;

	private SpriteBatch batch;
	private BitmapFont font;

	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		//viewport = new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
		viewport = new ExtendViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
		viewport.apply();
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		font = new BitmapFont();
		new Assets();
	}
	@Override
	public void resize(int width, int height) {
		float aspectRatio = (float)width/(float)height;
		Vector2 crop = new Vector2(0f, 0f);
		if(aspectRatio > ASPECT_RATIO) {System.out.println("#1");
			scale = (float)height/(float)VIRTUAL_HEIGHT;
			crop.x = (width - VIRTUAL_WIDTH * scale)/2f;
		} else if(aspectRatio < ASPECT_RATIO) {System.out.println("#2");
			scale = (float)width/(float)VIRTUAL_WIDTH;
			crop.y = (height - VIRTUAL_HEIGHT * scale)/2f;
		} else {System.out.println("#3");
			scale = (float)width/(float)VIRTUAL_WIDTH;
		}
		float w = (float)VIRTUAL_WIDTH * scale;
		float h = (float)VIRTUAL_HEIGHT * scale;
		//viewport.update((int)w, (int)h);
		viewport.update(width,height);
		//camera.position.set(crop.x, crop.y, 0);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
	}
	@Override
	public void render() {
		camera.update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		switch (Config.GAMESTATE) {
			case 0: // Logo state
				batch.draw(Assets.logo,
						(Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2) - Assets.logo.getWidth() / 2,
						(Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2) - Assets.logo.getHeight() / 2);
				if (Gdx.input.justTouched()) Config.GAMESTATE = 1;
				break;
			case 1: // Menu state
				if (Assets.bgm != null) Assets.bgm.stop();
				MenuState.update();
				batch.draw(Assets.menu_logo,
						(Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2) - Assets.menu_logo.getWidth() / 2,
						Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2);
				batch.draw(Assets.btn1_survival, MenuState.btn1_survival_x, MenuState.btn1_survival_y);
				batch.draw(Assets.btn2_scenario, MenuState.btn2_scenario_x, MenuState.btn2_scenario_y);
				batch.draw(Assets.btn3_stats, MenuState.btn3_stats_x, MenuState.btn3_stats_y);
				batch.draw(Assets.btn4_shop, MenuState.btn4_shop_x, MenuState.btn4_shop_y);
				batch.draw(Assets.btn5_sound, MenuState.btn5_sound_x, MenuState.btn5_sound_y);
				batch.draw(Assets.btn6_music, MenuState.btn6_music_x, MenuState.btn6_music_y);
				batch.draw(Assets.btn7_lang, MenuState.btn7_lang_x, MenuState.btn7_lang_y);
				break;
			case 2: // Game state - Survival mode
				batch.draw(Assets.background1_grass, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				Survival.update();
				if (GameState.tapped) batch.draw(Assets.tapShadow, Survival.touch_x - 20, Survival.touch_y - 20);
				for (int i = 0; i < Survival.enemies_tier1.size; i++)
					batch.draw(Assets.enemy1, Survival.enemies_tier1.get(i).x, Survival.enemies_tier1.get(i).y);
				for (int i = 0; i < Survival.enemies_tier2.size; i++)
					batch.draw(Assets.enemy2, Survival.enemies_tier2.get(i).x, Survival.enemies_tier2.get(i).y);
				for (int i = 0; i < Survival.enemies_tier3.size; i++)
					batch.draw(Assets.enemy3, Survival.enemies_tier3.get(i).x, Survival.enemies_tier3.get(i).y);
				for (int i = 0; i < Survival.enemies_tier4.size; i++)
					batch.draw(Assets.enemy4, Survival.enemies_tier4.get(i).x, Survival.enemies_tier4.get(i).y);
				for (int i = 0; i < Survival.enemies_tier5.size; i++)
					batch.draw(Assets.enemy5, Survival.enemies_tier5.get(i).x, Survival.enemies_tier5.get(i).y);
				font.draw(batch, "Silver: " + Config.SILVERAMOUNT, 100, 100);
				font.draw(batch, "Score: " + Config.LOCAL_SCORE, 100, 75);
				font.draw(batch, "Caught: " + Config.LOCAL_CAUGHT, 100, 50);
				font.draw(batch, "Passed: " + Config.LOCAL_PASSED, 100, 25);
				break;
			case 4:
				font.draw(batch, "You lose!\nMany zombies pass through your defence", 100, 125);
				if (Gdx.input.justTouched()) Config.GAMESTATE = 1;
				break;
		}
		batch.end();
	}

}
































































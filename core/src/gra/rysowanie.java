package gra;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Rysowanie wszystkiego co widzimy na ekranie
 */
public class rysowanie {

	/**
	 * Czcionka
	 */
	public BitmapFont font;
	
	/**
	 * Obsluga rysowania tekstur podczas gry 
	 */
	public SpriteBatch batch;
	
	/**
	 * Tekstura glowy w dol
	 */
	public Texture glowa_down;
	
	/**
	 * Tekstura glowy w lewo
	 */
	public Texture glowa_left;
	
	/**
	 * Tekstura glowy w gore
	 */
	public Texture glowa_up;
	
	/**
	 * Tekstura glowy w prawo
	 */
	public Texture glowa_right;
	
	/**
	 * Tekstura jablka
	 */
	public Texture apple;
	
	/**
	 * Tekstura ogonu pozioma
	 */
	public Texture ogon_poziom;
	
	/**
	 * Tekstura ogonu pionowa
	 */
	public Texture ogon_pion;
	
	/**
	 * Tekstura ogonu zakreconego w lewy gorny rog
	 */
	public Texture ogon_lg;
	
	/**
	 * Tekstura ogonu zakreconego w prawy dolny rog
	 */
	public Texture ogon_ld;
	
	/**
	 * Tekstura ogonu zakreconego w prawy dolny rog
	 */
	public Texture ogon_pd;
	
	/**
	 * Tekstura ogonu zakreconego w prawy gorny rog
	 */
	public Texture ogon_pb;
	
	/**
	 * Tekstura koncja ogonu obrucona w lewo
	 */
	public Texture koniec_left;
	
	/**
	 * Tekstura koncja ogonu obrucona w prawo
	 */
	public Texture koniec_right;
	
	/**
	 * Tekstura koncja ogonu obrucona w gore
	 */
	public Texture koniec_gora;
	
	/**
	 * Tekstura koncja ogonu obrucona w dol
	 */
	public Texture koniec_dol;
	
	/**
	 * Tekstura tla
	 */
	public Texture tlo;
	
	/**
	 * nazwa gracza
	 */
	public String name;
	
	/**
	 * Tekstura menu
	 */
	public Skin skin;
	
	/**
	 * Oblsuga rysowanie menu
	 */
	public Stage stage;
	
	/**
	 * Przyciski menu
	 */
	public TextButton Graj,NickZatw,Wyjdz,Wyjdz2,Ranking;
	
	/**
	 * Pole tekstowe w menu
	 */
	public TextField textField;
	
	/**
	 * Okresla czy rysowac ranking w menu 
	 */
	public boolean rankWys=false;

	/**
	 * Konstruktor przypisuje odpowiednie warosci do pol
	 */
	public rysowanie() {
		font = new BitmapFont(Gdx.files.internal("czcionka.fnt"));
		font.getData().setScale(1,1);
		batch = new SpriteBatch();
		glowa_down = new Texture("head_down.png");
		glowa_left = new Texture("head_left.png");
		glowa_right = new Texture("head_right.png");
		glowa_up = new Texture("head_up.png");
		apple = new Texture("apple.png");
		ogon_poziom = new Texture("body_horizontal.png");
		ogon_pion = new Texture("body_vertical.png");
		ogon_lg = new Texture("body_topleft.png");
		ogon_ld = new Texture("body_bottomleft.png");
		ogon_pd = new Texture("body_bottomright.png");
		ogon_pb = new Texture("body_topright.png");
		koniec_left = new Texture("tail_left.png");
		koniec_right = new Texture("tail_right.png");
		koniec_gora = new Texture("tail_up.png");
		koniec_dol = new Texture("tail_down.png");
		tlo = new Texture("tlo.png");
		name = "";
		
		//gui
		stage = new Stage();
	    Gdx.input.setInputProcessor(stage);
	    Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
	    textField = new TextField("", skin);
	    Graj = new TextButton("Graj",skin);
	    NickZatw = new TextButton("Zatwierdz Nick",skin);
	    Wyjdz = new TextButton("Wyjdz",skin);
	    Wyjdz2 = new TextButton("Wyjdz",skin);
	    Ranking = new TextButton("Ranking",skin);
	    
	    Graj.setPosition(250, 370);
	    Graj.setWidth(300);
	    
	    NickZatw.setPosition(250, 350);
	    NickZatw.setWidth(300);
	    NickZatw.setVisible(false);
	    
	    Wyjdz.setPosition(250, 230);
	    Wyjdz.setWidth(300);
	    
	    Wyjdz2.setPosition(250, 230);
	    Wyjdz2.setWidth(300);
	    Wyjdz2.setVisible(false);
	    
	    Ranking.setPosition(250, 300);
	    Ranking.setWidth(300);
	    
	    textField.setPosition(250, 300);
	    textField.setVisible(false);
	    textField.setWidth(300);
	    
	    stage.addActor(textField);
	    stage.addActor(Graj);
	    stage.addActor(NickZatw);
	    stage.addActor(Wyjdz);
	    stage.addActor(Wyjdz2);
	    stage.addActor(Ranking);
	}

	/**
	 * Metoda uzywana w momencie wylaczana gry
	 */
	public void close() {
		this.batch.dispose();
		this.font.dispose();
		this.glowa_down.dispose();
		this.glowa_up.dispose();
		this.glowa_left.dispose();
		this.glowa_right.dispose();
		this.apple.dispose();
		this.ogon_poziom.dispose();
		this.ogon_pion.dispose();
		this.ogon_lg.dispose();
		this.ogon_ld.dispose();
		this.ogon_pb.dispose();
		this.ogon_pd.dispose();
		this.koniec_left.dispose();
		this.koniec_right.dispose();
		this.koniec_gora.dispose();
		this.koniec_dol.dispose();
		this.tlo.dispose();
		this.stage.dispose();
	}

	/**
	 * Okresla ktory ekran wyswietlic 
	 * @param play Obiekt odpowiedzialny za obsluge i przechowywanie weza
	 * @param rank przechowuje ranking
	 * @throws InterruptedException obsluga wyjatku
	 */
	public void ekrany(waz play,ranking rank) throws InterruptedException{
		if(play.poczatek)
		{
			ekranStart(play,rank);
		}
		else
		{
			ekranKoniec(play,rank);
		}
	}
	
	/**
	 * Wyswietla ekran startowy
	 * @param play Obiekt odpowiedzialny za obsluge i przechowywanie weza
	 * @param rank przechowuje ranking
	 * @throws InterruptedException obsluga wyjatku
	 */
	public void ekranStart(waz play,ranking rank) throws InterruptedException{
	    Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	    batch.begin();
	    batch.draw(tlo, 0, 0);
	    int i=0;
	    if(rankWys) {
	    	rank.it = rank.ogon.iterator();
	    	while(rank.it.hasNext()) {
	    		rank.element = rank.it.next();
	    		i+=1;
	    		font.draw(batch, i+" "+rank.element.nazwa+" "+(rank.element.punkty-2),300, 600-i*50);
	    	}
	    }
    	batch.end();
	    
	    stage.act();
	    stage.draw();
	    
	    if(Wyjdz2.isPressed()) {
 	    	Graj.setChecked(false);
 	    	Graj.setVisible(true);
 	    	
 	    	NickZatw.setVisible(false);
 	    	
 	    	Wyjdz.setVisible(true);
 	    	
 	    	Wyjdz2.setVisible(false);
 	    	
 	    	Ranking.setVisible(true);
 	    	
 	    	textField.setVisible(false);
 	    	
 	    	Wyjdz2.setPosition(250, 230);
 	    	this.rankWys = false;
 	    }
	    
	    
	    if( Graj.isChecked()) { 
	    	Graj.setVisible(false);
	    	textField.setVisible(true);
	    	NickZatw.setVisible(true);
	    	Wyjdz.setVisible(false);
	    	Wyjdz2.setVisible(true);
	    	Ranking.setVisible(false);
	    	    	
	    if(NickZatw.isPressed()) {
	    	Graj.setVisible(true);
	    	if(textField.isVisible()) {
	    		if(textField.getText()!="") {
	    		play.gra=true;
	    		play.poczatek=false;
	    		rank.name = textField.getText();
	    		System.out.println(rank.name);	
	    		NickZatw.setVisible(false);
		    	Graj.setVisible(true);
		    	Wyjdz.setVisible(true);
		    	Ranking.setVisible(true);
		    	Wyjdz2.setVisible(false);
		    	textField.setVisible(false);
	    		}
	    		else
	    		{
	    			Graj.setVisible(false);
	    		}
	    	}
	    }
	}else if(Wyjdz.isChecked()) {
		Gdx.app.exit();
	}
	    
	    if(Ranking.isPressed()){
	    	Wyjdz2.setPosition(250, 100);
	    	NickZatw.setVisible(false);
	    	Graj.setVisible(false);
	    	Wyjdz.setVisible(false);
	    	Ranking.setVisible(false);
	    	Wyjdz2.setVisible(true);
	    	this.rankWys = true;
	    }
	    
}
	/**
	 * Wyswietla ekran koncowy
	 * @param play Obiekt odpowiedzialny za obsluge i przechowywanie weza
	 * @param rank przechowuje ranking
	 */
	public void ekranKoniec(waz play,ranking rank) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	    batch.begin();
	    batch.draw(tlo, 0, 0);
	    int i=0;
	    if(rankWys) {
	    	rank.it = rank.ogon.iterator();
	    	while(rank.it.hasNext()) {
	    		rank.element = rank.it.next();
	    		i+=1;
	    		font.draw(batch, i+" "+rank.element.nazwa+" "+(rank.element.punkty-2),300, 600-i*50);
	    	}
	    }
	    else
	    {
	    	font.draw(batch, "Wynik "+(play.punkty-2),350, 500);
	    }
    	batch.end();
		    stage.act();
		    stage.draw();
		    
		    if(Wyjdz2.isPressed()) {
		    	Graj.setChecked(false);
	 	    	Graj.setVisible(true);
	 	    	
	 	    	NickZatw.setVisible(false);
	 	    	
	 	    	Wyjdz.setVisible(true);
	 	    	
	 	    	Wyjdz2.setVisible(false);
	 	    	
	 	    	Ranking.setVisible(true);
	 	    	 	    	
	 	    	Wyjdz2.setPosition(250, 230);
	 	    	this.rankWys = false;
		    }
		    
		    if(Graj.isPressed()) {
		    	play.punktyMax = play.punkty;
		    	rank.punkty = play.punktyMax;
		    	rank.aktualizacja();
		    	play.gra = true;
		    	play.punkty = 2;
		    	play.ogon.removeAllElements();
		    }
		    
		    if(Wyjdz.isPressed()) {
		    	play.punktyMax = play.punkty;
		    	rank.punkty = play.punktyMax;
		    	rank.aktualizacja();
		    	Gdx.app.exit();
		    }
		    
		    if(Ranking.isPressed()){
		    	play.punktyMax = play.punkty;
		    	rank.punkty = play.punktyMax;
		    	rank.aktualizacja();
		    	Wyjdz2.setPosition(250, 100);
		    	NickZatw.setVisible(false);
		    	Graj.setVisible(false);
		    	Wyjdz.setVisible(false);
		    	Ranking.setVisible(false);
		    	Wyjdz2.setVisible(true);
		    	this.rankWys = true;
		    }
	}

	/**
	 * Wyswietla caly ekran poczas gry 
	 * @param play Obiekt odpowiedzialny za obsluge i przechowywanie weza 
	 */
	public void fps(waz play) {
		ScreenUtils.clear(0, 0, 0, 0);
		batch.begin();

		batch.draw(tlo, 0, 0);
		batch.draw(apple, play.applexy[0], play.applexy[1]);

		if(!play.ogon.isEmpty()) {
			play.it = play.ogon.iterator();
			play.it1 = play.ogon.iterator();
			play.dlugosc = 0;
			while (play.it.hasNext()) {
				if(play.it1.hasNext()) play.it1.next();
				play.ogon_old = play.it.next();
			    if(play.dlugosc==0)
			    {
			    	play.ogon_old = play.ogon.elementAt(0);
			    	switch(play.ogon_old.dir)
			    	{
			    	case 0:
			    		batch.draw(koniec_dol, play.ogon_old.x, play.ogon_old.y);
			    		break;

			    	case 1:
			    		batch.draw(koniec_gora, play.ogon_old.x, play.ogon_old.y);
			    		break;

			    	case 2:
			    		batch.draw(koniec_right, play.ogon_old.x, play.ogon_old.y);
			    		break;

			    	case 3:
			    		batch.draw(koniec_left, play.ogon_old.x, play.ogon_old.y);
			    		break;
			    	}
			    }
			    else if(!play.it.hasNext())
			    {
			    	play.ogon_add=play.ogon.elementAt(play.ogon.size()-2);

			    	if(play.ogon_old.dir==play.ogon_add.dir)
				    {
				    	switch(play.ogon_old.dir)
				    	{
				    	case 0:
				    		batch.draw(ogon_pion, play.ogon_old.x, play.ogon_old.y);
				    		break;

				    	case 1:
				    		batch.draw(ogon_pion, play.ogon_old.x, play.ogon_old.y);
				    		break;

				    	case 2:
				    		batch.draw(ogon_poziom, play.ogon_old.x, play.ogon_old.y);
				    		break;

				    	case 3:
				    		batch.draw(ogon_poziom, play.ogon_old.x, play.ogon_old.y);
				    		break;
				    	}
				    }
		    		else
		    		{
		    			if((play.ogon_add.dir==0)&&(play.ogon_old.dir==3))
		    			{
		    				batch.draw(ogon_pd, play.ogon_old.x, play.ogon_old.y);
		    			}

		    			if((play.ogon_add.dir==0)&&(play.ogon_old.dir==2))
		    			{
		    				batch.draw(ogon_ld, play.ogon_old.x, play.ogon_old.y);
		    			}

		    			if((play.ogon_add.dir==1)&&(play.ogon_old.dir==2))
		    			{
		    				batch.draw(ogon_lg, play.ogon_old.x, play.ogon_old.y);
		    			}

		    			if((play.ogon_add.dir==1)&&(play.ogon_old.dir==3))
		    			{
		    				batch.draw(ogon_pb, play.ogon_old.x, play.ogon_old.y);
		    			}
		    			//1 etap
		    			if((play.ogon_add.dir==3)&&(play.ogon_old.dir==0))
		    			{
		    				batch.draw(ogon_lg, play.ogon_old.x, play.ogon_old.y);
		    			}

		    			if((play.ogon_add.dir==3)&&(play.ogon_old.dir==1))
		    			{
		    				batch.draw(ogon_ld, play.ogon_old.x, play.ogon_old.y);
		    			}

		    			if((play.ogon_add.dir==2)&&(play.ogon_old.dir==0))
		    			{
		    				batch.draw(ogon_pb, play.ogon_old.x, play.ogon_old.y);
		    			}

		    			if((play.ogon_add.dir==2)&&(play.ogon_old.dir==1))
		    			{
		    				batch.draw(ogon_pd, play.ogon_old.x, play.ogon_old.y);
		    			}
		    		}
			    }
			    else
			    {
			    	play.ogon_s = play.ogon.elementAt(play.dlugosc-1);
			    		if(play.ogon_old.dir==play.ogon_s.dir)
					    {
					    	switch(play.ogon_old.dir)
					    	{
					    	case 0:
					    		batch.draw(ogon_pion, play.ogon_old.x, play.ogon_old.y);
					    		break;

					    	case 1:
					    		batch.draw(ogon_pion, play.ogon_old.x, play.ogon_old.y);
					    		break;

					    	case 2:
					    		batch.draw(ogon_poziom, play.ogon_old.x, play.ogon_old.y);
					    		break;

					    	case 3:
					    		batch.draw(ogon_poziom, play.ogon_old.x, play.ogon_old.y);
					    		break;
					    	}
					    }
			    		else
			    		{
			    			if((play.ogon_s.dir==0)&&(play.ogon_old.dir==3))
			    			{
			    				batch.draw(ogon_pd, play.ogon_old.x, play.ogon_old.y);
			    			}

			    			if((play.ogon_s.dir==0)&&(play.ogon_old.dir==2))
			    			{
			    				batch.draw(ogon_ld, play.ogon_old.x, play.ogon_old.y);
			    			}

			    			if((play.ogon_s.dir==1)&&(play.ogon_old.dir==2))
			    			{
			    				batch.draw(ogon_lg, play.ogon_old.x, play.ogon_old.y);
			    			}

			    			if((play.ogon_s.dir==1)&&(play.ogon_old.dir==3))
			    			{
			    				batch.draw(ogon_pb, play.ogon_old.x, play.ogon_old.y);
			    			}
			    			//1 etap
			    			if((play.ogon_s.dir==3)&&(play.ogon_old.dir==0))
			    			{
			    				batch.draw(ogon_lg, play.ogon_old.x, play.ogon_old.y);
			    			}

			    			if((play.ogon_s.dir==3)&&(play.ogon_old.dir==1))
			    			{
			    				batch.draw(ogon_ld, play.ogon_old.x, play.ogon_old.y);
			    			}

			    			if((play.ogon_s.dir==2)&&(play.ogon_old.dir==0))
			    			{
			    				batch.draw(ogon_pb, play.ogon_old.x, play.ogon_old.y);
			    			}

			    			if((play.ogon_s.dir==2)&&(play.ogon_old.dir==1))
			    			{
			    				batch.draw(ogon_pd, play.ogon_old.x, play.ogon_old.y);
			    			}
			    		}


			    }

play.dlugosc = play.dlugosc+1;
			}
		}
		int kierunek1 = 0;
		if(!play.ogon.isEmpty())
		{
			play.ogon_s = play.ogon.lastElement();
			kierunek1 = play.ogon_s.dir;
		}
		else
		{
			kierunek1 = play.kierunek;
		}

		if(kierunek1==0)
		{
			batch.draw(glowa_up, play.head_x, play.head_y);
		}
		if(kierunek1==1)
		{
			batch.draw(glowa_down, play.head_x, play.head_y);
		}
		if(kierunek1==2)
		{
			batch.draw(glowa_left, play.head_x, play.head_y);
		}
		if(kierunek1==3)
		{
			batch.draw(glowa_right, play.head_x, play.head_y);
		}
		font.draw(batch, "punkty:"+(play.punkty-2), 10, 590);
		batch.end();
	}
}

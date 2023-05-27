package com.mygdx.cardpickupch09;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.util.ArrayList;

public class LevelScreen extends BaseScreen {
    private ArrayList<Pile> pileList;

    private Label messageLabel;

    @Override
    public void initialize() {
        camera.setToOrtho(false, 800, 600);

        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("felt.jpg");
        BaseActor.setWorldBounds(background);

        for (int r = 0; r < Card.rankNames.length; r++) {
            for (int s = 0; s < Card.suitNames.length; s++) {
                int x = MathUtils.random(0, 800);
                int y = MathUtils.random(0, 300);
                Card c = new Card(x, y, mainStage);
                c.setRankSuitValues(r, s);
                c.toBack();
            }
        }

        background.toBack();

        pileList = new ArrayList<Pile>();
        for (int i = 0; i < 4; i++) {
            int pileX = 120 + 150 * i;
            int pileY = 450;
            Pile pile = new Pile(pileX, pileY, mainStage);
            pileList.add(pile);
        }

        for (BaseActor actor : BaseActor.getList(mainStage, "com.mygdx.cardpickupch09.Card")) {
            Card card = (Card) actor;
            if (card.getRankValue() == 0) {
                Pile pile = pileList.get(card.getSuitValue());
                card.toFront();
                card.moveToActor(pile);
                pile.addCard(card);
                card.setDraggable(false);
            }
        }

        messageLabel = new Label("...", BaseGame.labelStyle);
        messageLabel.setColor(Color.CYAN);
        uiTable.add(messageLabel).expandX().expandY().bottom().pad(50);
        messageLabel.setVisible(false);
    }

    @Override
    public void update(float dt) {
//        Vector3 touchPos = new Vector3();
//        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//        camera.unproject(touchPos);

        boolean complete = true;
        for (Pile pile : pileList)
        {
            if (pile.getSize() < 13)
                complete = false;
        }
        if (complete)
        {
            messageLabel.setText("You win!");
            messageLabel.setVisible(true);
        }
    }
}

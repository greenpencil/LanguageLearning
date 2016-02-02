package io.kpf.languagelearning.story.views;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Katie on 25/01/2016.
 */
public class ObjectView extends ImageView {
    int time;
    AnimationTimer wiggleTimer;
    AnimationTimer chatTimer;
    AnimationTimer fadeOutTimer;
    AnimationTimer fadeInTimer;
    Image openMouth;
    Image regularImage;

    public ObjectView() {
        super();
        //Wiggle Timer
        wiggleTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(time < 100) {
                    double sinWave = Math.sin(time * 0.36);
                    setRotate(sinWave * 10);
                    time++;
                } else {
                    setRotate(0);
                    this.stop();
                }
            }
        };
        chatTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(time < 200) {
                    if (time % 25 == 1) {
                        if (getImage() == openMouth) {
                            setImage(regularImage);
                        } else {
                            setImage(openMouth);
                        }
                    }
                    time++;
                }
                else {
                    setImage(regularImage);
                    this.stop();
                }
            }
        };
        fadeOutTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(time < 200) {
                    setOpacity((double)1-((double)(time/2)/100));
                    time++;
                }
                else {
                    this.stop();
                }
            }
        };
        fadeInTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(time < 200) {
                    setOpacity((double)(time/2)/100);
                    time++;
                }
                else {
                    this.stop();
                }
            }
        };
    }

    public Image getOpenMouth() {
        return openMouth;
    }

    public void setOpenMouth(Image openMouth) {
        this.openMouth = openMouth;
    }

    public Image getRegularImage() {
        return regularImage;
    }

    public void setRegularImage(Image regularImage) {
        this.regularImage = regularImage;
    }

    public void startWiggle()
    {
        time = 0;
        wiggleTimer.start();
    }

    public void startChat()
    {
        time = 0;
        chatTimer.start();
    }

    public void startFadeOut()
    {
        time = 0;
        fadeOutTimer.start();
    }

    public void startFadeIn()
    {
        time =0;
        fadeInTimer.start();
    }

    public void visible()
    {
        setOpacity(1);
    }

    public void invisible()
    {
        setOpacity(0);
    }
}

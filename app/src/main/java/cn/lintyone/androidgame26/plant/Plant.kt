package cn.lintyone.androidgame26.plant

import org.cocos2d.actions.base.CCRepeatForever
import org.cocos2d.actions.interval.CCAnimate
import org.cocos2d.nodes.CCAnimation
import org.cocos2d.nodes.CCSprite
import org.cocos2d.nodes.CCSpriteFrame
import java.util.*
import kotlin.collections.ArrayList

open class Plant(format: String, number: Int) : CCSprite(String.format(Locale.CHINA, format, 0)) {

    private val frames = ArrayList<CCSpriteFrame>()
    var hp = 100
    var price = 0

    init {
        this.setAnchorPoint(0.5f, 0f)
        for (i in 0 until number) {
            val spriteFrame = CCSprite.sprite(String.format(Locale.CHINA, format, i)).displayedFrame()
            frames.add(spriteFrame)
        }
        val animation = CCAnimation.animationWithFrames(frames, 0.2f)
        val animate = CCAnimate.action(animation, true)
        val repeatForever = CCRepeatForever.action(animate)
        this.runAction(repeatForever)
    }

    open fun hurtCompute(hurt: Int) {
        hp -= hurt
        if (hp < 0) {
            hp = 0
        }
    }
}

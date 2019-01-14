package com.planbcambodia.beloveproject.custom_layout

/**
 * Created by chhaihout on 1/11/2019.
 */
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.planbcambodia.beloveproject.R
import android.widget.TextView
import android.view.ViewGroup





class ExpandCollapseView : FrameLayout {
    var isExpanded:Boolean = false
    lateinit var valueAnimatorUpdateListener : ValueAnimator.AnimatorUpdateListener

    @JvmOverloads
    constructor(
            context: Context,
            attrs: AttributeSet? = null,
            defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr){
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.expand_collape_view, this, true)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        valueAnimatorUpdateListener = ValueAnimator.AnimatorUpdateListener { animation ->
            val animatedValue = animation.animatedValue
            this.layoutParams.height = animatedValue as Int
            this.requestLayout()
        }

        this.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        val height = this.measuredHeight + findAllTextView(this).sumBy { (it.lineCount - 1) * it.lineHeight }
    }

    fun expand(){
        if(isExpanded){
            return
        }else{
            isExpanded = true
            this.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            val height = this.measuredHeight + findAllTextView(this).sumBy { (it.lineCount - 1) * it.lineHeight }
            val valueAnimator = ValueAnimator.ofInt(0,height)
            valueAnimator.addUpdateListener(valueAnimatorUpdateListener)
            valueAnimator.duration = 500
            valueAnimator.start()
        }
    }

    private fun findAllTextView(v: ViewGroup): List<TextView> {
        var result:List<TextView> = ArrayList()
        (0 until v.childCount)
                .asSequence()
                .map { v.getChildAt(it) }
                .forEach {
                    if (it is TextView)
                        result+= it
                    else if (it is ViewGroup)
                        for (tv in findAllTextView(it))
                            result+=tv
                }
        return result
    }

    fun collapse(){
        if(!isExpanded){
            return
        }else{
            isExpanded = false
            val valueAnimator = ValueAnimator.ofInt(this.measuredHeight,0)
            valueAnimator.addUpdateListener(valueAnimatorUpdateListener)
            valueAnimator.duration = 500
            valueAnimator.start()
        }
    }
}
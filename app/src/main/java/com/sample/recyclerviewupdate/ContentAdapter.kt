package com.sample.recyclerviewupdate

import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ContentAdapter(
    private val itemList: List<String> = generateSequence { "Hello World" }.take(24).toList()
): Adapter<ContentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(ComposeView(parent.context))
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(itemList[position], position)
    }

    override fun getItemCount(): Int = itemList.size
}

class ContentViewHolder(private val composeView: ComposeView): ViewHolder(composeView) {
    fun bind(text: String, position: Int) {
        composeView.setContent {
            MaterialTheme {
                Text(
                    text = "$text: $position",
                    color = Color.White,
                    modifier = Modifier
                        .padding(10.dp)
                        .drawBehind {
                            drawRect(
                                color = Color.Blue,
                                size = size
                            )
                        }
                        .height(100.dp)
                        .fillMaxWidth())
            }
        }
    }
}
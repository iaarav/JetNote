package com.aarav.jettnote.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aarav.jettnote.R
import com.aarav.jettnote.components.NoteInputText
import com.aarav.jettnote.model.Note
import com.aarav.jettnote.components.noteButton
import com.aarav.jettnote.util.formatDate

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NoteScreen(
    notes: List<Note>, onAddNote: (Note) -> Unit, onRemoveNote: (Note) -> Unit
) {


    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    // content
    Column(modifier = Modifier.padding(8.dp)) {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name), color = Color.Black)
        }, actions = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = "Icon",
                tint = Color.Gray
            )
        }, colors = TopAppBarDefaults.smallTopAppBarColors(Color.LightGray))

        // Text Input and Save Button
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            NoteInputText(modifier = Modifier.padding(
                top = 20.dp, bottom = 5.dp
            ), text = title, label = "Title", onTextChange = {
                if (it.all { char ->
                        char.isLetterOrDigit() || char.isWhitespace()
                    }) title = it
            })

            NoteInputText(modifier = Modifier.padding(
                top = 5.dp, bottom = 8.dp
            ), text = description, label = "Add a note", onTextChange = {
                description = it
            })

            noteButton(text = "Save", onClick = {
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    onAddNote(Note(title = title, description = description))
                    title = ""
                    description = ""
                    Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                }
            })
        }
        Divider(modifier = Modifier.padding(5.dp))

        LazyColumn {
            items(notes) { note ->
                NoteRow(note = note, onNoteClick = {
                    onRemoveNote(it)
                })
            }
        }

    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier, note: Note, onNoteClick: (Note) -> Unit
) {
    Surface(
        modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp))
            .fillMaxWidth(),
        color = Color.LightGray,
        shadowElevation = 6.dp
    ) {
        Column(
            modifier
                .clickable {
                    onNoteClick(note)
                }
                .padding(5.dp), horizontalAlignment = Alignment.Start) {
            Text(text = note.title, style = MaterialTheme.typography.titleMedium)
            Text(text = note.description, style = MaterialTheme.typography.bodySmall)

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = formatDate(note.entryDate.time),
                    style = MaterialTheme.typography.labelSmall)
            }

        }
    }
}


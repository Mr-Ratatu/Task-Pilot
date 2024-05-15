package renat.task.pilot.screens.projects.presentation.items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import renat.task.pilot.screens.projects.presentation.ProjectsViewModel

@Composable
internal fun ProjectToolbar(
    viewModel: ProjectsViewModel,
) {
    Box(
        modifier = Modifier.height(56.dp)
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Projects"
                )
            },
            actions = {
//                Icon(
//                    modifier = Modifier
//                        .size(32.dp)
//                        .clip(CircleShape)
//                        .clickable { }
//                        .padding(6.dp),
//                    painter = painterResource(id = CoreViewR.drawable.ic_chart),
//                    contentDescription = ""
//                )
                Spacer(modifier = Modifier.width(16.dp))
//                Icon(
//                    modifier = Modifier
//                        .size(32.dp)
//                        .clip(CircleShape)
//                        .clickable { viewModel.navigateToCreateProjectScreen() }
//                        .padding(6.dp),
//                    painter = painterResource(id = CoreViewR.drawable.ic_add),
//                    contentDescription = ""
//                )
            }
        )
    }
}
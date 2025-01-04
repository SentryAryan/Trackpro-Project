/*
 * 
 * package track.pro.tasks.repository;
 * 
 * import java.util.List;
 * 
 * import track.pro.project.entites.Project; import
 * track.pro.tasks.entites.Task; import track.pro.user.entites.User;
 * 
 * public interface TaskRepository {
 * 
 * 
 * int fillTask(Task task);
 * 
 * List<Task> fetchAllTasks();
 * 
 * List<Project> fetchAllProjects();
 * 
 * List<User> fetchAllUsers();
 * 
 * 
 * 
 * Task fetchTaskById(int taskId);
 * 
 * void updateTask(Task task);
 * 
 * List<String> getCreatedAt(int userId);
 * }
 */





 
package track.pro.tasks.repository;
 
import java.util.List;
 
import track.pro.project.entites.Project;
import track.pro.tasks.entites.Task;
import track.pro.user.entites.User;
 
public interface TaskRepository {
 
	int fillTask(Task task);
 
	List<Task> fetchAllTasks();
 
	List<Project> fetchAllProjects();
 
	List<User> fetchAllUsers();
 
	Task fetchTaskById(int taskId);
 
	void updateTask(Task task);

	String getCreatedAt(int userId);
}
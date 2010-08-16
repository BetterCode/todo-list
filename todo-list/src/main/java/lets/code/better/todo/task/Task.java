package lets.code.better.todo.task;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Task implements Serializable {

	private static final long serialVersionUID = -2600316247367563474L;

	@Transient
	private static final Tasks tasks = new Tasks();

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String title;

	@Column
	private String descr;

	@Column
	private String executor;

	@Column
	private Date createdAt;

	@Column
	private Date startedAt;

	@Column
	private Date finishedAt;

	public Task(String title, String descr, String executor, Date createdAt) {
		this.title = title;
		this.descr = descr;
		this.executor = executor;
		this.createdAt = createdAt;
	}

	Task() { // usado pelo hibernate
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return descr;
	}

	public String getExecutor() {
		return executor;
	}

	public Date getCreatedAt() {
		return createdAt == null ? null : new Date(createdAt.getTime());
	}

	public Date getStartedAt() {
		return startedAt == null ? null : new Date(startedAt.getTime());
	}

	public Date getFinishedAt() {
		return finishedAt == null ? null : new Date(finishedAt.getTime());
		
	}

	public boolean isStarted() {
		return startedAt != null;
	}

	public boolean isFinished() {
		return finishedAt != null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("Task [id=%s, title=%s, descr=%s, executor=%s, createdAt=%s, finishedAt=%s, startedAt=%s]",
						id, title, descr, executor, createdAt, finishedAt,
						startedAt);
	}

	public static Task create(String title, String description, String executor) {
		Task task = new Task(title, description, executor, new Date());
		tasks.save(task);
		return task;
	}

	public static Task findById(Integer id) {
		return tasks.findById(Task.class, id);
	}

	public static List<Task> list() {
		return tasks.list();
	}

	public Task start() {
		startedAt = new Date();
		tasks.save(this);
		return this;
	}
	
	public Task finish() {
		if (startedAt == null){
			startedAt = new Date();
		}
		finishedAt = new Date();
		tasks.save(this);
		return this;
	}

}

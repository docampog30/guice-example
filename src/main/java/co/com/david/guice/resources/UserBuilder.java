package co.com.david.guice.resources;

import java.util.UUID;

import co.com.david.guice.model.User;

public class UserBuilder {
	
	private UUID id;

	public UserBuilder withId(UUID randomUUID) {
		this.setId(randomUUID);
		return this;
	}

	public User build() {
		return new User(this);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}

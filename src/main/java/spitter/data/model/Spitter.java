package spitter.data.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
//    input field NAME must be the same as name of the field in java model
    @NotNull
    @Size(min=3, max=25)
    private String name;
    @NotNull
    @Size(min=3, max=25)
    private String surname;
    @NotNull
    @Size(min=3, max=25)
    private String username;
    @NotNull
    @Size(min=3, max=25)
    private String password;

    @NotNull
    @Size(min = 3, max = 25)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Spitter(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public Spitter() {
    }

    public Spitter(@NotNull @Size(min = 3, max = 25) String name, @NotNull @Size(min = 3, max = 25) String surname, @NotNull @Size(min = 3, max = 25) String username) {
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o, "password");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "password");
    }
}

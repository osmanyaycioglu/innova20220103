package com.training.innova.test.tdd.project.database;

import java.time.LocalDate;

public class Person {

    private String    name;
    private String    surname;
    private int       weight;
    private LocalDate birthdate;

    public String getName() {
        return this.name;
    }

    public Person setName(final String nameParam) {
        this.name = nameParam;
        return this;
    }

    public String getSurname() {
        return this.surname;
    }

    public Person setSurname(final String surnameParam) {
        this.surname = surnameParam;
        return this;
    }

    public int getWeight() {
        return this.weight;
    }

    public Person setWeight(final int weightParam) {
        this.weight = weightParam;
        return this;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public Person setBirthdate(final LocalDate birthdateParam) {
        this.birthdate = birthdateParam;
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.birthdate == null) ? 0 : this.birthdate.hashCode());
        result = (prime * result) + ((this.name == null) ? 0 : this.name.hashCode());
        result = (prime * result) + ((this.surname == null) ? 0 : this.surname.hashCode());
        result = (prime * result) + this.weight;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        if (this.birthdate == null) {
            if (other.birthdate != null) {
                return false;
            }
        } else if (!this.birthdate.equals(other.birthdate)) {
            return false;
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.surname == null) {
            if (other.surname != null) {
                return false;
            }
        } else if (!this.surname.equals(other.surname)) {
            return false;
        }
        if (this.weight != other.weight) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person [name="
               + this.name
               + ", surname="
               + this.surname
               + ", weight="
               + this.weight
               + ", birthdate="
               + this.birthdate
               + "]";
    }


}

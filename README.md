# ORM Assignment 1

Definition about anotations use in this Assignment.

# @OneToMany and @GeneratedValue
In this project you can find two entitys with one to many relationship the @GeneratedValue(strategy = GenerationType.IDENTITY) will automatically generate a uniqe id the use of mappedBy in the @OneToMany annotation helps to establish a bidirectional relationship and specifies that the author field in the Book entity manages the relationship.This used to generate primary key values for the entity.

# @JoinColumn
The @JoinColumn annotation is used in JPA (Java Persistence API) to specify the mapping of a foreign key column. It is typically used in associations between entities to define the column in the database table that represents the foreign key relationship.

# @Entity
By annotating a class with @Entity, you're specifying that instances of this class should be mapped to a table in the database. The name of the table is typically derived from the name of the entity class unless explicitly specified.

# @Id
Define the Primary key of a table when it create database using entity

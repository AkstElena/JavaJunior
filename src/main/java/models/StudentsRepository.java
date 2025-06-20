package models;

public interface StudentsRepository extends Repository<Student, Integer>{
    // Здесь можно прописать методы, котрые подходят именно для сущности студент, но допустим не для учителя
}

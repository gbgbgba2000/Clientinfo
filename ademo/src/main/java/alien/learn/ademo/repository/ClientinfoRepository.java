package alien.learn.ademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import alien.learn.ademo.entity.Clientinfo;

public interface ClientinfoRepository extends JpaRepository<Clientinfo, Integer> {

    Clientinfo findByName(String name);

};

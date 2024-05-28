package alien.learn.ademo.service;

//import alien.learn.ademo.dto.ClientinfoDto;
import alien.learn.ademo.entity.Clientinfo;
import alien.learn.ademo.repository.ClientinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientinfoService {

    @Autowired
    private ClientinfoRepository repository;

    public Clientinfo saveClientInfo(Clientinfo clientInfo) {
        return repository.save(clientInfo);
    }

    public List<Clientinfo> getAllClientInfos() {
        return repository.findAll();
    }

    public Clientinfo getClientInfoById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Clientinfo getClientInfoByName(String name) {
        return repository.findByName(name);
    }

    public Clientinfo updateClientInfo(Clientinfo clientInfo) {
        return repository.save(clientInfo);
    }

    public void deleteClientInfo(Integer id) {
        repository.deleteById(id);
    }

}

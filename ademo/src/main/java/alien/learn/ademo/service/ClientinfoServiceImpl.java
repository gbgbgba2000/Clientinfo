
package alien.learn.ademo.service;

import alien.learn.ademo.entity.Clientinfo;
import alien.learn.ademo.repository.ClientinfoRepository;
//import alien.learn.ademo.service.ClientinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientinfoServiceImpl implements ClientinfoService {

    @Autowired
    private ClientinfoRepository repository;

    @Override
    public Clientinfo saveClientInfo(Clientinfo clientInfo) {
        return repository.save(clientInfo);
    }

    @Override
    public List<Clientinfo> getAllClientInfos() {
        return repository.findAll();
    }

    @Override
    public Clientinfo getClientInfoById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Clientinfo getClientInfoByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Clientinfo updateClientInfo(Clientinfo clientInfo) {
        return repository.save(clientInfo);
    }

    @Override
    public void deleteClientInfo(Integer id) {
        repository.deleteById(id);
    }
}

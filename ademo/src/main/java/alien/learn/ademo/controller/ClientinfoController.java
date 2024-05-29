/*package alien.learn.ademo.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import alien.learn.ademo.GcpStorageConfig;
import alien.learn.ademo.entity.Clientinfo;

import alien.learn.ademo.service.ClientinfoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.Storage;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;

@RestController
@RequestMapping("/clientInfos")
public class ClientinfoController {

  @Autowired
  private ClientinfoService service;

  @Autowired
  private GcpStorageConfig gcpStorageConfig;

  private Storage storage;

  @Autowired
  public void init() throws IOException {
    Resource resource = new ClassPathResource("credentials.json");
    GoogleCredentials credentials = GoogleCredentials.fromStream(resource.getInputStream());
    storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

  }

  @PostMapping
  public Clientinfo addClientInfo(@RequestBody Clientinfo clientInfo) {
    return service.saveClientInfo(clientInfo);
  }

  @GetMapping
  public List<Clientinfo> getAllClientInfos() {
    return service.getAllClientInfos();
  }

  @GetMapping("/{id}")
  public Clientinfo getClientInfoById(@PathVariable Integer id) {
    return service.getClientInfoById(id);
  }

  @GetMapping("/byName/{name}")
  public Clientinfo getClientInfoByName(@PathVariable String name) {
    return service.getClientInfoByName(name);
  }

  @PutMapping
  public Clientinfo updateClientInfo(@RequestBody Clientinfo clientInfo) {
    return service.updateClientInfo(clientInfo);
  }

  @DeleteMapping("/{id}")
  public void deleteClientInfo(@PathVariable Integer id) {
    service.deleteClientInfo(id);
  }

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
    String bucketName = gcpStorageConfig.getBucket();
    String fileName = file.getOriginalFilename();
    BlobInfo blobInfo = storage.create(
        BlobInfo.newBuilder(bucketName, fileName).build(),
        file.getBytes());

    return String.format("File %s uploaded to bucket %s as %s",
        fileName, bucketName, blobInfo.getName());
  }

}*/

package alien.learn.ademo.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import alien.learn.ademo.GcpStorageConfig;
import alien.learn.ademo.entity.Clientinfo;
import alien.learn.ademo.service.ClientinfoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.Storage;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;

@RestController
@RequestMapping("/clientInfos")
public class ClientinfoController {

  @Autowired
  private ClientinfoService service;

  @Autowired
  private GcpStorageConfig gcpStorageConfig;

  private Storage storage;

  @Autowired
  public void init() throws IOException {
    Resource resource = new ClassPathResource("credentials.json");
    GoogleCredentials credentials = GoogleCredentials.fromStream(resource.getInputStream());
    storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
  }

  @PostMapping
  public Clientinfo addClientInfo(@RequestBody Clientinfo clientInfo) {
    return service.saveClientInfo(clientInfo);
  }

  @GetMapping
  public List<Clientinfo> getAllClientInfos() {
    return service.getAllClientInfos();
  }

  @GetMapping("/{id}")
  public Clientinfo getClientInfoById(@PathVariable Integer id) {
    return service.getClientInfoById(id);
  }

  @GetMapping("/byName/{name}")
  public Clientinfo getClientInfoByName(@PathVariable String name) {
    return service.getClientInfoByName(name);
  }

  @PutMapping
  public Clientinfo updateClientInfo(@RequestBody Clientinfo clientInfo) {
    return service.updateClientInfo(clientInfo);
  }

  @DeleteMapping("/{id}")
  public void deleteClientInfo(@PathVariable Integer id) {
    service.deleteClientInfo(id);
  }

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
    String bucketName = gcpStorageConfig.getBucket();
    String fileName = file.getOriginalFilename();
    BlobInfo blobInfo = storage.create(
        BlobInfo.newBuilder(bucketName, fileName).build(),
        file.getBytes());

    return String.format("File %s uploaded to bucket %s as %s",
        fileName, bucketName, blobInfo.getName());
  }
}

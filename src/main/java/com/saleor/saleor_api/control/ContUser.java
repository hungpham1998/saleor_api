package com.saleor.saleor_api.control;

import com.saleor.saleor_api.data.Resp;
import com.saleor.saleor_api.repo.RepoUser;
import com.saleor.saleor_api.table.User;
import com.saleor.saleor_api.service.SerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/user")
public class ContUser {

    @Autowired
    SerUser serUser;

    @Autowired
    RepoUser repoUser;

    //-- Lấy toàn bộ danh sách
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    @CrossOrigin(origins = "*", maxAge = 3600)
//    public ResponseEntity<?> getAllUser(Pageable pageable) {
//        return new ResponseEntity<>(serUser.getDtoUserPage(pageable), HttpStatus.OK);
//    }
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    @CrossOrigin(origins = "*", maxAge = 3600)
//    public ResponseEntity<Map<String, Object>> getAll()
//    {
//        Resp resp = new Resp();
//        Map<String, Object> response =  new HashMap<>();
//        try {
//            List<DtoUser> data = serUser.GetAll();
//            resp.setSuccess(true);
//            resp.setMsg("Ok");
//            resp.setData(data);
//
//            response.put("data",resp.getData());
//            response.put("success",resp.getSuccess());
//            response.put("message", resp.getMsg());
//            return new ResponseEntity<>(response,HttpStatus.OK);
//        }
//        catch (Exception e){
//            resp.setSuccess(false);
//            response.put("success",resp.getSuccess());
//            response.put("error", e);
//            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @RequestMapping(value = "/getbyid/{userId}/shop", method = RequestMethod.GET)
//    @CrossOrigin(origins = "*", maxAge = 3600)
//    public ResponseEntity<?> getByID(@PathVariable Long userId) {
//        return new ResponseEntity<>(serUser.getShopInfoByUserId(userId), HttpStatus.OK);
//    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<?> getUserById(@RequestParam(value = "id", required = false) Long id) {
        Map<String,Object> response = new HashMap<>();
        Optional<User> data = serUser.getUser(id);
        User user = data.get();
        if(!data.isPresent()){
            response.put("success", false);
            response.put("data",null);
        }
        else{
            response.put("success", true);
            response.put("data",user);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



//    @RequestMapping(value = "/find", method = RequestMethod.GET)
//    @CrossOrigin(origins = "*", maxAge = 3600)
//    public ResponseEntity<?> getByUsernameContainingOrEmailContaining( String query) {
//        return new ResponseEntity<>(serUser. FindBy(query), HttpStatus.OK);
//    }
//
//    //- Thêm
//    @RequestMapping(value = "/ins", method = RequestMethod.POST)
//    @CrossOrigin(origins = "*", maxAge = 3600)
//    public ResponseEntity<?> Insert(@RequestBody User user) {
//        return new ResponseEntity<>(serUser.InsUser(user), HttpStatus.OK);
//    }
//
//    //-- Sửa
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @CrossOrigin(origins = "*", maxAge = 3600)
//    public ResponseEntity<?> update(@RequestBody User user) {
//        return new ResponseEntity<>(serUser.Update(user), HttpStatus.OK);
//    }
//
//    //-- Xóa
//    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
//    @CrossOrigin(origins = "*", maxAge = 3600)
//    public ResponseEntity<?> delete(@RequestParam Long id) {
//        User data = serUser.FindById(id).orElse(null);
//        if (data == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            serUser.Delete(id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//    }

        @RequestMapping( value = "/update", method = RequestMethod.POST)
        @CrossOrigin(origins = "*", maxAge = 3600)
        public ResponseEntity<Map<String, Object>> updateSent( @RequestBody User User) {
            Resp resp = new Resp();
            Map<String, Object> response = new HashMap<>();
            try {
                User user = serUser.AccountUpdate(User);
                resp.setData(user);
                response.put("data", resp.getData());
                response.put("success",true);
                response.put("message", "ok");
                return new ResponseEntity<>(response, HttpStatus.OK);

            } catch (Exception e) {
                response.put("success", false);
                response.put("error", e.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}


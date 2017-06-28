/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula7.Controller;

import br.com.crescer.aula4.tema.Video;
import br.com.cwi.crescer.aula7.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author alana.weiss
 */
@Controller
public class VideoRest {

    @Autowired
    VideoService service;

    @ResponseBody
    @RequestMapping(value = "/Video", method = RequestMethod.GET)
    public Iterable<Video> list() {
        return service.find();
    }

    @ResponseBody
    @RequestMapping(value = "/Video", method = RequestMethod.POST)
    public Video list(@RequestBody Video a) {
        return service.save(a);
    }
    
    @ResponseBody
    @RequestMapping(value = "/Video", method = RequestMethod.PUT)
    public Video update(@RequestBody Video a) {
        return service.update(a);
    }
}

package com.nuuptech.poc.datagrid.controller;

import com.nuuptech.poc.datagrid.model.User;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CacheController {

    private final RemoteCacheManager cacheManager;

    @Autowired
    public CacheController(RemoteCacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        // Obtener un cache. Esto creará un nuevo cache si no existe.
        RemoteCache<String, String> cache = cacheManager.getCache("cuentas");
        // Escribir datos en el cache
        cache.put("clave", "valor");
        // Devuelve un status 201 Created
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


}

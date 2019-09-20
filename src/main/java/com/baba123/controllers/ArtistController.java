package com.baba123.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baba123.dtos.ArtistDto;
import com.baba123.services.ArtistService;


@RestController
@RequestMapping("/artist")
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public void createArtist(@RequestBody ArtistDto artistDto){
		artistService.createArtist(artistDto);
	}

	@RequestMapping(value="", method = RequestMethod.GET)
	public ArtistDto getArtistById(@RequestParam(value="id", required = true) Long artistId,
			@RequestParam(value = "name", required = false) String name) {
		System.out.println("id : " + artistId + " , name : " + name);
		return artistService.getArtistById(artistId);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ArtistDto getArtistFromId(@PathVariable(value="id") Long artistId,
			@RequestHeader(value="auth-token") String authToken) {
		System.out.println("auth token :"  + authToken);
		
		return artistService.getArtistById(artistId);
		
	}
	
	@RequestMapping(value ="/detail/genre",method=RequestMethod.GET)
	public ArtistDto getArtistDetail(@RequestParam(value="id") Long artistId,
			@RequestParam(value="detail",required=true) String detail) {
	System.out.println("detail :" + detail + " id " + artistId);
	return artistService.getArtistById(artistId);
	}
	

}
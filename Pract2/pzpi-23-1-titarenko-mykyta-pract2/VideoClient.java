@FeignClient(name = "video-metadata-service")
public interface VideoClient {
    
    @RequestMapping(method = RequestMethod.GET, value = "/metadata/{movieId}")
    VideoMetadata getMetadata(@PathVariable("movieId") String movieId);
}
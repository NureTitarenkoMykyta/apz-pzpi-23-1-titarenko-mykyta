public class GetRecommendationsCommand extends HystrixCommand<List<String>> {

    private final String userId;
    private final RecommendationService service;

    public GetRecommendationsCommand(RecommendationService service, String userId) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RecommendationGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(1000)));
        this.service = service;
        this.userId = userId;
    }

    @Override
    protected List<String> run() throws Exception {
        return service.fetchFromRemote(userId);
    }

    @Override
    protected List<String> getFallback() {
        return Arrays.asList("Trending Now", "Popular on Netflix", "Top 10 Today");
    }
}
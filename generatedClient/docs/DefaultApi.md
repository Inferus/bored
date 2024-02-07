# DefaultApi

All URIs are relative to *http://www.boredapi.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**activityGet**](DefaultApi.md#activityGet) | **GET** /activity | Get a random activity |


<a id="activityGet"></a>
# **activityGet**
> activityGet(key)

Get a random activity

Retrieve a random activity suggestion

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://www.boredapi.com/api");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String key = "key_example"; // String | API key for authentication
    try {
      apiInstance.activityGet(key);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#activityGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **key** | **String**| API key for authentication | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **0** | No activity found |  -  |


package microservices.jobsite.authservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {

    private String timestamp;

    private String url;

    private String status;

    private Map<?, ?> details;


    public void setTimestamp(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.timestamp = dateFormat.format(date);
    }

}

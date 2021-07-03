package lk.icoder.uploadexcel.message;

/**
 * @Project upload-excel
 * @Author DILAN on 7/3/2021
 */
public class ResponseMessage {

   private String message;

   public ResponseMessage(String message) {
      this.message = message;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }
}

package sql.jdbc;


import lombok.Data;

@Data  //自动生成get set方法
public class Good {
   private int gid;
   private String gname;
   private float gprice;
   private int gnum;
   /*
   public int getGid() {
      return gid;
   }

   public void setGid(int gid) {
      this.gid = gid;
   }


   public String getGname() {
      return gname;
   }

   public void setGname(String gname) {
      this.gname = gname;
   }

   public float getGprice() {
      return gprice;
   }

   public void setGprice(float gprice) {
      this.gprice = gprice;
   }

   public int getGnum() {
      return gnum;
   }

   public void setGnum(int gnum) {
      this.gnum = gnum;
   }

   @Override
   public String toString() {
      return "Good{" +
              "gid=" + gid +
              ", gname='" + gname + '\'' +
              ", gprice=" + gprice +
              ", gnum=" + gnum +
              '}';
   }
   */
}

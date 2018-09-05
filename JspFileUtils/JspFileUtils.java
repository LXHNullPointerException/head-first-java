import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 使用IO流来获取指定文件夹中的所有的JSP页面
 */
public class JspFileUtils {
    // JSP文件夹的绝对路径
    public static final String TARGET_FILE_DIRECTORY = "D:\\IDEAResources\\mainland-official-store\\speedo-store-mobile\\src\\main\\webapp\\pages\\";
    // JSP文件的前缀名称:http://localhost:8082/pages/
    public static final String REQUEST_URL_PREFIX = "http://localhost:8082/pages/";
    // 读取文件的缓存流
    private static BufferedReader bufferedReader;

   	public static void main(String[] args) throws Exception{
   		// 使用文件对象来封装目标文件夹
        //File targetFile = new File("F:\\develop\\GitProjects\\mainland-official-store\\speedo-store-mobile\\src\\main\\webapp\\pages");
        //File targetFile = new File("F:\\develop\\GitProjects\\mainland-official-store\\speedo-store-mobile\\src\\main\\webapp\\pages\\activityList\\90th-anniversary-new.jsp");
        File targetFile = new File(TARGET_FILE_DIRECTORY);
        // File targetFile = new File("F:\\develop\\GitProjects\\mainland-official-store\\speedo-store-mobile\\src\\main\\webapp\\pages\\category\\fastskin.jsp");
        // File targetFile = new File("F:\\develop\\GitProjects\\mainland-official-store\\speedo-store-mobile\\src\\main\\webapp\\pages\\commons\\cms\\cms-page.jsp");
        // 列出目标文件夹中的所有文件
        JspFileUtils.listAllJspFilesByTargetFileDirectory(targetFile);
   	}

    /**
     * @param targetFile JSP文件夹
     * @throws Exception
     */
    public static void listAllJspFilesByTargetFileDirectory(File targetFile) throws Exception {
        if (targetFile.isDirectory()) {
            System.out.println();
            System.out.println("目录:" + targetFile.getPath().replace(TARGET_FILE_DIRECTORY, ""));
            System.out.println("文件\t\t服务端返回值\t\t访问的URL地址");
            File[] jspFiles = targetFile.listFiles();
            for (File currentFile : jspFiles) {
                listAllJspFilesByTargetFileDirectory(currentFile);
            }
        } else {
            bufferedReader = new BufferedReader(new FileReader(targetFile.getAbsolutePath()));
            String strLineContent = null;
            // 该标志为true表示,需要对该JSP文件进行添加滚动条,false表示已经完成了,不需要修改
            boolean isNeededToBeDealedWith = true;
            while ((strLineContent = bufferedReader.readLine()) != null) {
                if (strLineContent.contains("cate_title_mob")) {
                    isNeededToBeDealedWith = false;
                    break;
                }
            }
            if (isNeededToBeDealedWith) {
                // 获取文件的名称:campaign\buildyourswimkit.jsp
                String tmpFileName = targetFile.getPath().replace(TARGET_FILE_DIRECTORY, "");
                // 获取服务端返回的URL地址
                String serverReturnUrl = tmpFileName.replace(".jsp", "").replace("\\", ".");
                // 获取请求的URL地址
                String requestUrl = REQUEST_URL_PREFIX + tmpFileName;
                requestUrl = requestUrl.replace("\\", "/");
                System.out.println(tmpFileName + "\t\t" + serverReturnUrl + "\t\t" + requestUrl);
            }
        }
    }
}

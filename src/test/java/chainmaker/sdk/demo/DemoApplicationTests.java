package chainmaker.sdk.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static chainmaker.sdk.demo.InitClient.inItChainClient;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testChainmaker() throws Exception {
        inItChainClient();
        //查询链配置
        ChainConfig.getChainConfig(InitClient.chainClient);
//        //创建合约
//        Contract.createContract(InitClient.chainClient, InitClient.user);
//        //调用合约
//        Contract.invokeContract(InitClient.chainClient);
//        //查询合约
        Contract.queryContract(InitClient.chainClient);
        //订阅区块
        new Thread(new Subscribe()).start();
        //等待订阅
        Thread.sleep(1000 * 10);
    }

    /**
     * 测试查询合约的接口
     * @throws Exception
     */
    @Test
    void testQuery() throws Exception {
        inItChainClient();

        Contract.invokeEvidenceContract(InitClient.chainClient);

        Thread.sleep(1000 * 1);
    }

}

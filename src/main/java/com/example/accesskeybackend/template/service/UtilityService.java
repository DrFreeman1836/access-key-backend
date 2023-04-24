package com.example.accesskeybackend.template.service;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import org.springframework.stereotype.Service;

@Service
public class UtilityService {

  public Boolean checkIpv6(String siteUrl) {
    try {
      URI uri = new URI(siteUrl);
      String domain = uri.getHost();
      InetAddress[] addresses = InetAddress.getAllByName(domain);
      for (InetAddress address : addresses) {
        if (address instanceof Inet6Address) {
          String ipv6Address = address.getHostAddress();
          URL url = new URL("http://[" + ipv6Address + "]");
          URLConnection connection = url.openConnection();
          connection.setConnectTimeout(3000);
          connection.connect();
          return true;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

}

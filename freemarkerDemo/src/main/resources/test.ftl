<html>
<head>
<meta charset="GBK">
<title>DEMO</title>
</head>
<body>
<#include "header.ftl">

<#--��ֻ��һ��ע�ͣ��Ҳ������κ����  -->
${name},hello${message}

<#--����һ����������-->
<#assign linkman="Lucy">
<br>
��ϵ��:${linkman}
<#--����һ������ķ��ɵ���-->
<#assign text="{'iphone':'152364854','address':'��ͨ�к�����'}"/>
<br>
<#assign data=text?eval/>
�绰����:${data.iphone}  <br> ��ַ:${data.address}
<br>
�绰����:${data.iphone}  <br> ��ַ:${data.address}
<br>

<#if success=true>
  ����ͨ��ʵ����֤
<#else>  
  ��δͨ��ʵ����֤
</#if>
<br>
---��Ʒ�б�----
<#list goodList as good>
<br>
${good_index+1}
 ��Ʒ���� ${good.name}   ��Ʒ�۸� ${good.price}<br>
<br>
һ������  ${goodList?size}  ��
<br>
-----ʱ��--------
<br>
ʱ�䣺${tody?time}<br>
���ڣ�${tody?date}<br>
����+ʱ�䣺${tody?datetime}<br>

����:${point?c}
</#list>

<#--���ǿ��ж�-->
<br>
<#if aaa??>
ִ��ifaaa${aaa}
<#else>
ִ��o((>��< ))o
</#if>
<br>
${bbb!'��Ϊ��'}
<br>
<#if (point>100)>
�ƽ��Ա
</#if>



</body>
</html>

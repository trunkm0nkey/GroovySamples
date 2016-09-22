def file = "../conf/ldap.xml"
def config = new XmlSlurper().parse(file)

def url = config.URL
assert url == "ldap://ldap.example.org"

def port = config.Port
assert port == 389

def dn = config.DN
assert dn == "uid=admin,ou=People,dc=example,dc=org"

def password = config.Password
assert password == "FakePass123"

def filterAttr = config.FilterAttr
assert filterAttr == "uid"

def scope = config.Scope
assert scope == "sub"

def roleList = config.Attributes.Attr.collect()
assert roleList == ["uid","mail","cn"]